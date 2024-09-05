package com.arun.project.uberApplication.services.implementation;

import com.arun.project.uberApplication.dto.DriverDto;
import com.arun.project.uberApplication.dto.RideDto;
import com.arun.project.uberApplication.dto.RiderDto;
import com.arun.project.uberApplication.services.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DriverServiceImplementation implements DriverService {


    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto startRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto endRide(Long rideId) {
        return null;
    }

    @Override
    public RiderDto rateRider(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RideDto acceptRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return List.of();
    }
}
