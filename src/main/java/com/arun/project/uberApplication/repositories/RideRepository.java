package com.arun.project.uberApplication.repositories;

import com.arun.project.uberApplication.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
}
