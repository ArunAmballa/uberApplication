package com.arun.project.uberApplication.controllers;

import com.arun.project.uberApplication.dto.SignupDto;
import com.arun.project.uberApplication.dto.UserDto;
import com.arun.project.uberApplication.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public UserDto signUpUser(@RequestBody  SignupDto signupDto){
        return authService.signup(signupDto);
    }
}
