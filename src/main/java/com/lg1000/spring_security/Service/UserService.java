package com.lg1000.spring_security.Service;

import com.lg1000.spring_security.Model.User;
import com.lg1000.spring_security.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(10);
    public List<User> getAllUser(){
        return repo.findAll();
    }
    public User getUserByUsername(String un){
        return repo.getUserByUsername(un);
    }
    public void registerUser(User usr){
        usr.setPassword(encoder.encode(usr.getPassword()));
        repo.save(usr);
    }
}
