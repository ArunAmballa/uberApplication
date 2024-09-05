package com.arun.project.uberApplication.repositories;

import com.arun.project.uberApplication.entities.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RideRequestRepository extends JpaRepository<RideRequest, Long> {
}
