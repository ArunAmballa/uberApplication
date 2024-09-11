package com.arun.project.uberApplication.services;

import com.arun.project.uberApplication.dto.DriverDto;
import com.arun.project.uberApplication.dto.RideDto;
import com.arun.project.uberApplication.dto.RiderDto;
import com.arun.project.uberApplication.entities.Driver;

import java.util.List;

public interface DriverService {

    RideDto cancelRide(Long rideId);

    RideDto startRide(Long rideId,String otp);

    RideDto endRide(Long rideId);

    RiderDto rateRider(Long rideId,Integer rating);


    RideDto acceptRide(Long rideRequestId);


    DriverDto getMyProfile();


    List<RideDto> getAllMyRides();


    Driver getCurrentDriver();
}
