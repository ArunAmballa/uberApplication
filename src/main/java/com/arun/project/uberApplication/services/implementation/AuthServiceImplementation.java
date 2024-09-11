package com.arun.project.uberApplication.services.implementation;

import com.arun.project.uberApplication.dto.DriverDto;
import com.arun.project.uberApplication.dto.SignupDto;
import com.arun.project.uberApplication.dto.UserDto;
import com.arun.project.uberApplication.entities.Rider;
import com.arun.project.uberApplication.entities.User;
import com.arun.project.uberApplication.entities.enums.Role;
import com.arun.project.uberApplication.exceptions.RuntimeConflictException;
import com.arun.project.uberApplication.repositories.RiderRepository;
import com.arun.project.uberApplication.repositories.UserRepository;
import com.arun.project.uberApplication.services.AuthService;
import com.arun.project.uberApplication.services.RiderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImplementation implements AuthService {

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    private final RiderService riderService;


    @Override
    public String login(String email, String password) {
        return "";
    }

    //Signup does not need spring security
    @Override
    @Transactional
    public UserDto signup(SignupDto signupDto) {

        User checkUser=userRepository.findByEmail(signupDto.getEmail()).orElse(null);
        if(checkUser!=null) {
            throw new RuntimeConflictException("User already exists with email: " + signupDto.getEmail());
        }

        User user=modelMapper.map(signupDto, User.class);
        log.info(user.toString());
        user.setRoles(Set.of((Role.RIDER)));
        User savedUser=userRepository.save(user);

        //create User related entities

        riderService.createNewRider(savedUser);

        //TODO add Wallet related Services

        return modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public DriverDto onBoardNewDriver(Long userId) {
        return null;
    }
}
