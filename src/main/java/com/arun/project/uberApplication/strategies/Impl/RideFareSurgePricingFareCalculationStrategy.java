package com.arun.project.uberApplication.strategies.Impl;

import com.arun.project.uberApplication.dto.RideRequestDto;
import com.arun.project.uberApplication.entities.RideRequest;
import com.arun.project.uberApplication.services.DistanceService;
import com.arun.project.uberApplication.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        Double distance=distanceService.calculateDistance(rideRequest.getPickUpLocation(),rideRequest.getDropOffLocation());
        return distance*RIDE_FARE_MULTIPLIER*RIDE_FARE_SURGE;

    }
}
