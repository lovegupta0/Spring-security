package com.lg1000.spring_security.Service;

import com.lg1000.spring_security.Config.CredentialManager;
import com.lg1000.spring_security.Model.User;
import com.lg1000.spring_security.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User usr=repo.getUserByUsername(username);
        if(usr==null) throw new UsernameNotFoundException("No user Found");
        return new CredentialManager(usr);
    }
}
