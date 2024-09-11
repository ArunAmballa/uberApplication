package com.arun.project.uberApplication.services.implementation;

import com.arun.project.uberApplication.dto.RideRequestDto;
import com.arun.project.uberApplication.entities.Driver;
import com.arun.project.uberApplication.entities.Ride;
import com.arun.project.uberApplication.entities.RideRequest;
import com.arun.project.uberApplication.entities.enums.RideRequestStatus;
import com.arun.project.uberApplication.entities.enums.RideStatus;
import com.arun.project.uberApplication.exceptions.ResourceNotFoundException;
import com.arun.project.uberApplication.repositories.RideRepository;
import com.arun.project.uberApplication.services.RideRequestService;
import com.arun.project.uberApplication.services.RideService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
@RequiredArgsConstructor
public class RideServiceImplementation implements RideService {

    private final RideRepository rideRepository;

    private final ModelMapper modelMapper;

    private final RideRequestService rideRequestService;

    @Override
    public Ride getRideById(Long rideId) {
        return rideRepository.findById(rideId).orElseThrow(()->new ResourceNotFoundException("Ride not found"));
    }

    @Override
    public void matchWithDriver(RideRequestDto rideRequestDto) {

    }

    @Override
    public Ride createNewRide(RideRequest rideRequest, Driver driver) {

        rideRequest.setStatus(RideRequestStatus.CONFIRMED);

        Ride ride = modelMapper.map(rideRequest, Ride.class);
        ride.setRidestatus(RideStatus.CONFIRMED);
        ride.setDriver(driver);
        ride.setOtp(generateRandomOTP());
        ride.setId(null);
        rideRequestService.update(rideRequest);
        return rideRepository.save(ride);


    }

    @Override
    public Ride updateRideStatus(Ride ride, RideStatus rideStatus) {
        ride.setRidestatus(rideStatus);
        Ride savedRide = rideRepository.save(ride);
        return savedRide;
    }

    @Override
    public Page<Ride> getAllRidesOfRider(Long riderId, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest) {
        return null;
    }

    private String generateRandomOTP(){

        Random random = new Random();
        int otpInt = random.nextInt(10000);  //0 to 9999
        return String.format("%04d", otpInt);
    }

}
