package com.lg1000.spring_security.Controller;

import com.lg1000.spring_security.Model.User;
import com.lg1000.spring_security.Service.JwtService;
import com.lg1000.spring_security.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager manager;
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

    @PostMapping("login")
    public String login(@RequestBody User user){
        Authentication authentication= manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }
        return "failed to login";
    }
}
