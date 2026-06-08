package com.exchange.exchange.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.exchange.exchange.dto.RegisterRequest;
import com.exchange.exchange.dto.RegisterResponse;
import com.exchange.exchange.service.UserService;


@RestController
@RequestMapping("/api")
public class AuthController {
    private final UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest request){
        return userService.registerUser(request);
    }
}
