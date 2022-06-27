package com.robert.springsecurityrestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class SpringSecurityRestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityRestDemoApplication.class, args);
    }

}
