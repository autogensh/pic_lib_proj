package com.piclib.web.service;

import com.piclib.web.dao.UserMapper;
import com.piclib.web.entity.User;
import com.piclib.web.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;

    @Autowired
    private void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    private void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(s);
        List<com.piclib.web.entity.User> users = userMapper.selectByExample(userExample);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("用户名或者密码错误");
        }
        User user = users.get(0);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        String[] roles = user.getRole().split(",");
        HashSet<GrantedAuthority> authorities = new HashSet<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
        user.setAuthorities(authorities);
        return user;
    }
}
