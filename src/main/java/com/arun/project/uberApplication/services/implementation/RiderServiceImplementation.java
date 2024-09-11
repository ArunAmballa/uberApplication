package com.arun.project.uberApplication.services.implementation;

import com.arun.project.uberApplication.dto.DriverDto;
import com.arun.project.uberApplication.dto.RideDto;
import com.arun.project.uberApplication.dto.RideRequestDto;
import com.arun.project.uberApplication.dto.RiderDto;
import com.arun.project.uberApplication.entities.*;
import com.arun.project.uberApplication.entities.enums.RideRequestStatus;
import com.arun.project.uberApplication.repositories.RideRequestRepository;
import com.arun.project.uberApplication.repositories.RiderRepository;
import com.arun.project.uberApplication.services.RiderService;
import com.arun.project.uberApplication.strategies.RideStrategyManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImplementation implements RiderService {

    private final ModelMapper modelMapper;

    private final RiderRepository riderRepository;

    private final RideStrategyManager rideStrategyManager;

    private final RideRequestRepository rideRequestRepository;

    @Override
    @Transactional
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        Rider rider = getCurrentRider();

        RideRequest rideRequest=modelMapper.map(rideRequestDto,RideRequest.class);
        rideRequest.setStatus(RideRequestStatus.PENDING);
        rideRequest.setRider(rider);
        Double fare=rideStrategyManager.rideFareCalculationStrategy().calculateFare(rideRequest);
        rideRequest.setFare(fare);
        RideRequest savedRideRequest=rideRequestRepository.save(rideRequest);
        List<Driver> matchingDrivers = rideStrategyManager.driverMatchingStrategy(rider.getRating()).findMatchingDrivers(rideRequest);

        //TODO Send Email to all Drivers to accept the ride request

        return modelMapper.map(savedRideRequest,RideRequestDto.class);
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

    @Override
    public Rider createNewRider(User user) {
        Rider rider = Rider.builder()
                .user(user)
                .rating(0.0)
                .build();
        return riderRepository.save(rider);
    }

    @Override
    public Rider getCurrentRider() {

        //TODO Implement Spring Security
        return riderRepository.findById(1L).orElseThrow(()-> new RuntimeException("Rider not found"));
    }
}
