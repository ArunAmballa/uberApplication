package com.arun.project.uberApplication.services.implementation;

import com.arun.project.uberApplication.dto.DriverDto;
import com.arun.project.uberApplication.dto.SignupDto;
import com.arun.project.uberApplication.dto.UserDto;
import com.arun.project.uberApplication.services.AuthService;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImplementation implements AuthService {
    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public UserDto signup(SignupDto signupDto) {
        return null;
    }

    @Override
    public DriverDto onBoardNewDriver(Long userId) {
        return null;
    }
}
