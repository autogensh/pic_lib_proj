package com.piclib.web;

import com.piclib.web.util.Constants;
import org.im4java.process.ProcessStarter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
@MapperScan("com.piclib.web.dao")
public class PiclibWebApplication {
    public static void main(String[] args) {
        ProcessStarter.setGlobalSearchPath(Constants.globalSearchPath);
        SpringApplication.run(PiclibWebApplication.class, args);
    }
}
