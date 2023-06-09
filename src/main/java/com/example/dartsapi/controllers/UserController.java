package com.example.dartsapi.controllers;

import com.example.dartsapi.dto.user.UserCreateDTO;
import com.example.dartsapi.dto.user.UserLoginDTO;
import com.example.dartsapi.dto.user.UserReadDTO;
import com.example.dartsapi.model.User;
import com.example.dartsapi.services.UserService;
import org.springframework.web.bind.annotation.*;

import static com.example.dartsapi.mappers.users.UserToDTOMapper.userToReadDTO;

@RestController
public class UserController {

    private UserService us = new UserService();


    @GetMapping(path = "users/{id}")
    public UserReadDTO getOne(@PathVariable("id") String id) {
        return userToReadDTO(us.findOneById(id));
    }

    @GetMapping(path = "users/email/{email}")
    public UserReadDTO getOneByEmail(@PathVariable("email") String email) {
        User user = us.getOneByEmail(email);
        if (user != null) {
            return userToReadDTO(us.getOneByEmail(email));
        } else {
            return null;
        }

    }

    @PostMapping(path = "users/add")
    public UserReadDTO createOne(@RequestBody UserCreateDTO dto) {
        return us.addOne(dto);
    }



}
