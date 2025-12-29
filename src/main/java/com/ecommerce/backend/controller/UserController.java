package com.ecommerce.backend.controller;

import com.ecommerce.backend.model.User;
import com.ecommerce.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository repo;

    @PostMapping("/signup")
    public String signup(@RequestBody User user){
        if(repo.existsByEmail(user.getEmail())){
            return "Email already exists ❌";
        }
        repo.save(user);
        return "Signup Successful ✔";
    }

    @GetMapping("/all")
    public java.util.List<User> getAll(){
        return repo.findAll();
    }
}
