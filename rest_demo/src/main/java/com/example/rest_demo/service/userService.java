package com.example.rest_demo.service;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.rest_demo.model.user;

@Service
@Primary
public interface userService {

    // add user
    user addUser(user u);

    // get user by id

    user login(String email, String password) throws Exception;

}
