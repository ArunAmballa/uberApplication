package com.arun.project.uberApplication.strategies;

import com.arun.project.uberApplication.dto.RideRequestDto;

public interface RideFareCalculationStrategy {

    double calculateFare(RideRequestDto rideRequestDto);
}
