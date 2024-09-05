package com.arun.project.uberApplication.services.implementation;

import com.arun.project.uberApplication.dto.DriverDto;
import com.arun.project.uberApplication.dto.RideDto;
import com.arun.project.uberApplication.dto.RideRequestDto;
import com.arun.project.uberApplication.dto.RiderDto;
import com.arun.project.uberApplication.services.RiderService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RiderServiceImplementation implements RiderService {
    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        return null;
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RiderDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return List.of();
    }
}
