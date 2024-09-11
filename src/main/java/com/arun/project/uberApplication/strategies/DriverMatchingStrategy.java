package com.arun.project.uberApplication.strategies;

import com.arun.project.uberApplication.dto.RideRequestDto;
import com.arun.project.uberApplication.entities.Driver;
import com.arun.project.uberApplication.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {
   public List<Driver> findMatchingDrivers(RideRequest rideRequest);
}
