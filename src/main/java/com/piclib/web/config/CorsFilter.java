package com.piclib.web.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootConfiguration
@WebFilter(filterName = "CorsFilter",urlPatterns = {"/*"})
@Order(value = 0)
@Component
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest reqs = (HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:9528");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,OPTIONS,PATCH,DELETE,HEAD");
        response.setHeader("Access-Control-Allow-Headers", "x-token,content-type");
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}
