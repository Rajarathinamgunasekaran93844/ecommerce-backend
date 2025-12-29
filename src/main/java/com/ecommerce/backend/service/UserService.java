package com.ecommerce.backend.service;

import com.ecommerce.backend.model.User;
import com.ecommerce.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(User user){

        if(repo.existsByEmail(user.getEmail()))
            return "Email already exists ❌";

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);

        return "Signup Successful ✔";
    }

    public List<User> getAllUsers(){
        return repo.findAll();
    }
}
