package com.ecommerce.backend.controller;

import com.ecommerce.backend.model.SignupRequest;
import com.ecommerce.backend.model.User;
import com.ecommerce.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody SignupRequest request) {
        return userService.registerUser(request);
    }
}
