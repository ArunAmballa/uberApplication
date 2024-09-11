package com.arun.project.uberApplication.services;


import com.arun.project.uberApplication.entities.RideRequest;

public interface RideRequestService {

    public RideRequest findRideRequestById(Long rideRequestId);

    void update(RideRequest rideRequest);
}
