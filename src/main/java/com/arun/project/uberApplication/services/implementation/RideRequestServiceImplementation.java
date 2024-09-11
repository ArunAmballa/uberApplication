package com.arun.project.uberApplication.services.implementation;

import com.arun.project.uberApplication.entities.RideRequest;
import com.arun.project.uberApplication.exceptions.ResourceNotFoundException;
import com.arun.project.uberApplication.repositories.RideRequestRepository;
import com.arun.project.uberApplication.services.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestServiceImplementation implements RideRequestService {

    private final RideRequestRepository rideRequestRepository;


    @Override
    public RideRequest findRideRequestById(Long rideRequestId) {
        return rideRequestRepository.findById(rideRequestId).orElseThrow(()->new ResourceNotFoundException("RideRequest with id " + rideRequestId + " not found"));
    }

    @Override
    public void update(RideRequest rideRequest) {
       rideRequestRepository.findById(rideRequest.getId()).orElseThrow(() -> new ResourceNotFoundException("RideRequest with id " + rideRequest.getId() + " not found"));
       rideRequestRepository.save(rideRequest);
    }


}
