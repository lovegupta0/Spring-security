package com.lg1000.spring_security.Repo;

import com.lg1000.spring_security.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    public User getUserByUsername(String username);
}
