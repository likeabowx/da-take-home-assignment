package com.takehomeassignment.tasks.controller;

import com.takehomeassignment.tasks.service.TokenService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String login(Authentication authentication) {
        String token = tokenService.generateToken(authentication);
        return token;
    }
}
