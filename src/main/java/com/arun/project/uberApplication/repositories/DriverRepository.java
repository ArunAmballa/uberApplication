package com.arun.project.uberApplication.repositories;

import com.arun.project.uberApplication.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
}
