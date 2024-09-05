package com.arun.project.uberApplication.services.implementation;

import com.arun.project.uberApplication.dto.RideRequestDto;
import com.arun.project.uberApplication.entities.Driver;
import com.arun.project.uberApplication.entities.Ride;
import com.arun.project.uberApplication.entities.enums.RideStatus;
import com.arun.project.uberApplication.services.RideService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class RideServiceImplementation implements RideService {
    @Override
    public Ride getRideById(Long rideId) {
        return null;
    }

    @Override
    public void matchWithDriver(RideRequestDto rideRequestDto) {

    }

    @Override
    public Ride createNewRide(RideRequestDto rideRequestDto, Driver driver) {
        return null;
    }

    @Override
    public Ride updateRideStatus(Long rideId, RideStatus rideStatus) {
        return null;
    }

    @Override
    public Page<Ride> getAllRidesOfRider(Long riderId, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest) {
        return null;
    }
}
