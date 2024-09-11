package com.arun.project.uberApplication.strategies;

import com.arun.project.uberApplication.dto.RideRequestDto;
import com.arun.project.uberApplication.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER=10;
    double RIDE_FARE_SURGE=10;
    double calculateFare(RideRequest rideRequest);
}
