package com.arun.project.uberApplication.strategies;

import com.arun.project.uberApplication.dto.RideRequestDto;
import com.arun.project.uberApplication.entities.Driver;

import java.util.List;

public interface DriverMatchingStrategy {

   public List<Driver> findMatchingDriver(RideRequestDto rideRequestDto);
}
