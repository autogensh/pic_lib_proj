package com.piclib.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class PersistentTokenRepository extends JdbcTokenRepositoryImpl {

    @Autowired
    public PersistentTokenRepository(DataSource dataSource) {
        super();
        setDataSource(dataSource);
    }
}
