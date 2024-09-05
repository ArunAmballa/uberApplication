package com.arun.project.uberApplication.strategies.Impl;

import com.arun.project.uberApplication.dto.RideRequestDto;
import com.arun.project.uberApplication.entities.Driver;
import com.arun.project.uberApplication.strategies.DriverMatchingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {
    @Override
    public List<Driver> findMatchingDriver(RideRequestDto rideRequestDto) {
        return List.of();
    }
}
