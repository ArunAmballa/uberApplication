package com.arun.project.uberApplication.controllers;


import com.arun.project.uberApplication.dto.RideRequestDto;
import com.arun.project.uberApplication.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rider")
@RequiredArgsConstructor
public class RiderController {

    private final RiderService riderService;

    @PostMapping("/requestRide")
    public RideRequestDto requestRide(@RequestBody  RideRequestDto rideRequestDto) {
        return riderService.requestRide(rideRequestDto);
    }

}
