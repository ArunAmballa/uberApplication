package com.arun.project.uberApplication.strategies;

import com.arun.project.uberApplication.strategies.Impl.DriverMatchingHighestRatedDriverStrategy;
import com.arun.project.uberApplication.strategies.Impl.DriverMatchingNearestDriverStrategy;
import com.arun.project.uberApplication.strategies.Impl.RideFareDefaultFareCalculationStrategy;
import com.arun.project.uberApplication.strategies.Impl.RideFareSurgePricingFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {

    private final DriverMatchingNearestDriverStrategy driverMatchingNearestDriverStrategy;

    private final DriverMatchingHighestRatedDriverStrategy driverMatchingHighestRatedDriverStrategy;

    private final RideFareDefaultFareCalculationStrategy rideFareDefaultFareCalculationStrategy;

    private final RideFareSurgePricingFareCalculationStrategy rideFareSurgePricingFareCalculationStrategy;


    // Deciding Driver Matching Strategy at run time Based on rider rating

    public DriverMatchingStrategy driverMatchingStrategy(double rating){
        if(rating >= 4.8){
            return driverMatchingHighestRatedDriverStrategy;
        }
        else{
            return driverMatchingNearestDriverStrategy;
        }
    }

    //Deciding RideFare Calculation Strategy Based on time

    public RideFareCalculationStrategy rideFareCalculationStrategy(){

        //SURGE TIME 6PM to 9PM

        LocalTime surgeStartTime= LocalTime.of(18,0);
        LocalTime surgeEndTime= LocalTime.of(21,0);
        LocalTime currentTime=LocalTime.now();

        if(currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime)){
            return rideFareSurgePricingFareCalculationStrategy;
        }else{
            return rideFareDefaultFareCalculationStrategy;
        }
    }
}
