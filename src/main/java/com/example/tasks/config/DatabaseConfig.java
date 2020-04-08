package com.example.tasks.config;

import com.example.tasks.domain.Authority;
import com.example.tasks.service.AuthorityService;
import com.example.tasks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseConfig {

    @Autowired AuthorityService authorityService;
    @Autowired UserService userService;


    @PostConstruct
    public void init() {
        authorityService.init();
        userService.init();
    }

}
