package com.arun.project.uberApplication.services;

import com.arun.project.uberApplication.dto.DriverDto;
import com.arun.project.uberApplication.dto.SignupDto;
import com.arun.project.uberApplication.dto.UserDto;

public interface AuthService {

    String login(String email, String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onBoardNewDriver(Long userId);


}
