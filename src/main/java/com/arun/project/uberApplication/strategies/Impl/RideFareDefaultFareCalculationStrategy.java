package com.arun.project.uberApplication.strategies.Impl;

import com.arun.project.uberApplication.dto.RideRequestDto;
import com.arun.project.uberApplication.strategies.RideFareCalculationStrategy;

public class RideFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequestDto rideRequestDto) {
        return 0;
    }
}
