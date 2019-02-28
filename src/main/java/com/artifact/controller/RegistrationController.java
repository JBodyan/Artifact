package com.artifact.controller;

import com.artifact.app.domain.other.Message;
import com.artifact.app.domain.entity.User;
import com.artifact.app.domain.other.Role;
import com.artifact.app.domain.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/1.0/registration", produces = "application/json")
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private Gson gson;

    @GetMapping
    public String registerGet(){
        return gson.toJson(new Message(1,"Info","Hello Registration GET!"));
    }

    @PostMapping
    public String registerNewUser(User user){
        User userFromDB = userService.getByUsername(user.getUsername());
        if(userFromDB != null){
            return gson.toJson(new Message(1,"Error","User with this username already exists"));
        }else{
            Set<Role> roles = new HashSet<>();
            roles.add(Role.USER);
            user.setActive(true);
            user.setRole(roles);
            userService.save(user);
            return gson.toJson(new Message(2,"Info","User created"));
        }
    }

}
