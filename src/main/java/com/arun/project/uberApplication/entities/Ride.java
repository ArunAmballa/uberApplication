package com.arun.project.uberApplication.entities;


import com.arun.project.uberApplication.entities.enums.PaymentMethod;
import com.arun.project.uberApplication.entities.enums.RideRequestStatus;
import com.arun.project.uberApplication.entities.enums.RideStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Geometry(Point, 4326)") // 4326 deals with earth
    private Point pickUpLocation;

    @Column(columnDefinition = "Geometry(Point, 4326)") // 4326 deals with earth
    private Point dropOffLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rider rider;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @Enumerated(EnumType.STRING)
    private RideStatus ridestatus;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @CreationTimestamp
    private LocalDateTime createdTime; // When the driver accepts the ride

    private Double fare;

    private String otp;

    private LocalDateTime startedAt; // When the driver starts the ride

    private LocalDateTime endedAt; //when the driver ends the ride
}
