package com.arun.project.uberApplication.services.implementation;

import com.arun.project.uberApplication.dto.DriverDto;
import com.arun.project.uberApplication.dto.RideDto;
import com.arun.project.uberApplication.dto.RiderDto;
import com.arun.project.uberApplication.entities.Driver;
import com.arun.project.uberApplication.entities.Ride;
import com.arun.project.uberApplication.entities.RideRequest;
import com.arun.project.uberApplication.entities.enums.RideRequestStatus;
import com.arun.project.uberApplication.entities.enums.RideStatus;
import com.arun.project.uberApplication.repositories.DriverRepository;
import com.arun.project.uberApplication.services.DriverService;
import com.arun.project.uberApplication.services.RideRequestService;
import com.arun.project.uberApplication.services.RideService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;



@Service
@RequiredArgsConstructor
public class DriverServiceImplementation implements DriverService {

    private final RideRequestService rideRequestService;

    private final DriverRepository driverRepository;

    private final RideService rideService;

    private final ModelMapper modelMapper;

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto startRide(Long rideId,String otp) {
        Ride ride = rideService.getRideById(rideId);
        Driver driver=getCurrentDriver();
        if(!driver.equals(ride.getDriver())) {
            throw new RuntimeException("Driver Cannot Start a ride because it's not the driver accepted earlier");
        }
        if(!ride.getRidestatus().equals(RideStatus.CONFIRMED)){
            throw new RuntimeException("Ride Status is not CONFIRMED");
        }
        if(!otp.equals(ride.getOtp())) {
            throw new RuntimeException("OTP is not valid");
        }
        ride.setStartedAt(LocalDateTime.now());
        Ride savedRide = rideService.updateRideStatus(ride, RideStatus.ONGOING);
        return modelMapper.map(savedRide, RideDto.class);
    }

    @Override
    public RideDto endRide(Long rideId) {
        return null;
    }

    @Override
    public RiderDto rateRider(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RideDto acceptRide(Long rideRequestId) {

        // Check if Ride Request Exists and no Driver has still accepted the RideRequest

        RideRequest rideRequest = rideRequestService.findRideRequestById(rideRequestId);

        if(!rideRequest.getStatus().equals(RideRequestStatus.PENDING)){
            throw new RuntimeException("Ride Request Cannot be accepted its status:"+rideRequest.getStatus());
        }

        // Check if Driver is Available

        Driver currentDriver=getCurrentDriver();
        if(!currentDriver.getAvailable()){
            throw new RuntimeException("Current Driver is not available");
        }

        currentDriver.setAvailable(false);
        Driver savedDriver = driverRepository.save(currentDriver);
        Ride newRide = rideService.createNewRide(rideRequest, savedDriver);

        return modelMapper.map(newRide,RideDto.class);
    }

    @Override
    public DriverDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return List.of();
    }

    @Override
    public Driver getCurrentDriver() {
        return driverRepository.findById(2L).orElseThrow(()->new RuntimeException("Current Driver not Found"));
    }
}
