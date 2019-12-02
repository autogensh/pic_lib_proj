package com.piclib.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.piclib.web.dao.UserMapper;
import com.piclib.web.entity.User;
import com.piclib.web.model.JsonResp;
import com.piclib.web.model.LoginSuccessResp;
import com.piclib.web.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private PasswordEncoder passwordEncoder;
    private ObjectMapper objectMapper;
    private UserDetailsServiceImpl userDetailsService;
    private DataSource dataSource;
    private PersistentTokenRepository tokenRepository;
    private UserMapper userMapper;

    @Autowired
    private void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    private void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

    @Autowired
    private void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Autowired
    private void setUserDetailsService(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    private void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/css/**", "/js/**").permitAll()
                .antMatchers("/admin/login").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/admin/login").loginProcessingUrl("/admin/login")
                .failureHandler(new LoginFailureHandler())
                .usernameParameter("username").passwordParameter("password")
                .successHandler(new AjaxLoginSuccessHandler(objectMapper, userMapper)).failureHandler(new AjaxLoginFailHandler(objectMapper))
                .and()
                .logout().logoutUrl("/admin/logout")
                .logoutSuccessHandler(new AjaxLogoutSuccessHandler(objectMapper))
                .and()
                .rememberMe().userDetailsService(userDetailsService).tokenRepository(persistentTokenRepository())
                .and()
                .exceptionHandling().authenticationEntryPoint(new UnauthorizedEntryPoint())
                .and()
                .csrf().disable();
    }

    public static class UnauthorizedEntryPoint implements AuthenticationEntryPoint {
        static boolean isAjaxRequest(HttpServletRequest request) {
            String ajaxFlag = request.getHeader("X-Requested-With");
            return "XMLHttpRequest".equals(ajaxFlag);
        }

        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
            if (isAjaxRequest(request)) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
            } else {
                response.sendRedirect("/admin/login");
            }
        }
    }

    public static class AjaxLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
        private ObjectMapper objectMapper;
        private UserMapper userMapper;

        AjaxLoginSuccessHandler(ObjectMapper objectMapper, UserMapper userMapper) {
            this.objectMapper = objectMapper;
            this.userMapper = userMapper;
        }

        @Override
        public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication auth) throws IOException, ServletException {
            this.updateLastLoginInfo(req, resp, auth);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json; charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.append(objectMapper.writeValueAsString(new LoginSuccessResp(req.getSession().getId())));
            writer.close();
        }

        private void updateLastLoginInfo(HttpServletRequest req, HttpServletResponse resp, Authentication auth) {
            User user = new User();
            user.setId(((User) auth.getPrincipal()).getId());
            user.setLastLoginIP(((WebAuthenticationDetails) auth.getDetails()).getRemoteAddress());
            user.setLastLoginTime(new Date());
            userMapper.updateByPrimaryKeySelective(user);
        }
    }

    public static class AjaxLoginFailHandler extends SimpleUrlAuthenticationFailureHandler {
        private ObjectMapper objectMapper;

        AjaxLoginFailHandler(ObjectMapper objectMapper) {
            this.objectMapper = objectMapper;
        }

        @Override
        public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException exception) throws IOException, ServletException {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json; charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.append(objectMapper.writeValueAsString(JsonResp.usernameOrPasswordError()));
            writer.close();
        }
    }

    public static class LoginFailureHandler implements AuthenticationFailureHandler {
        @Override
        public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
            resp.sendRedirect("/admin/login");
        }
    }

    public static class AjaxLogoutSuccessHandler implements LogoutSuccessHandler {
        private ObjectMapper objectMapper;

        AjaxLogoutSuccessHandler(ObjectMapper objectMapper) {
            this.objectMapper = objectMapper;
        }

        @Override
        public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication auth) throws IOException, ServletException {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json; charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.append(objectMapper.writeValueAsString(JsonResp.success()));
            writer.close();
        }
    }

}
