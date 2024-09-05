package com.arun.project.uberApplication.repositories;

import com.arun.project.uberApplication.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
}
