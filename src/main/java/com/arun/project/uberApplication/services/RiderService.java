package com.arun.project.uberApplication.services;

import com.arun.project.uberApplication.dto.DriverDto;
import com.arun.project.uberApplication.dto.RideDto;
import com.arun.project.uberApplication.dto.RideRequestDto;
import com.arun.project.uberApplication.dto.RiderDto;

import java.util.List;

public interface RiderService {

    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);

    DriverDto rateDriver(Long rideId, Integer rating );

    RiderDto getMyProfile();

    List<RideDto> getAllMyRides();
}
