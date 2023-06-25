package com.example.dartsapi.controllers;

import com.example.dartsapi.dto.user.UserLoginDTO;
import com.example.dartsapi.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private UserService us = new UserService();

    @PostMapping(path = "/login", consumes = "application/json")
    public String canAccess(@RequestBody UserLoginDTO dto) {
        String result = us.authenticate(dto.getEmail(), dto.getPassword());
        if (result != null) {
            return result;
        } else {
            return null;
        }
    }
}
