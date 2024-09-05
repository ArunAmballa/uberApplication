package com.arun.project.uberApplication.services;

import com.arun.project.uberApplication.dto.DriverDto;
import com.arun.project.uberApplication.dto.RideDto;
import com.arun.project.uberApplication.dto.RiderDto;

import java.util.List;

public interface DriverService {

    RideDto cancelRide(Long rideId);

    RideDto startRide(Long rideId);

    RideDto endRide(Long rideId);

    RiderDto rateRider(Long rideId,Integer rating);


    RideDto acceptRide(Long rideId);


    DriverDto getMyProfile();


    List<RideDto> getAllMyRides();
}
