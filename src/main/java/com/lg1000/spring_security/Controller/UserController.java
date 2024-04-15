package com.lg1000.spring_security.Controller;

import com.lg1000.spring_security.Model.User;
import com.lg1000.spring_security.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String started(){
        return "server started...";
    }

    @GetMapping("users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("register")
    public void registerUser(@RequestBody User user){
        userService.registerUser(user);
    }
}
