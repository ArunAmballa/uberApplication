package com.arun.project.uberApplication.entities;


import com.arun.project.uberApplication.entities.enums.PaymentMethod;
import com.arun.project.uberApplication.entities.enums.RideRequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Geometry(Point, 4326)") // 4326 deals with earth
    private Point pickUpLocation;

    @Column(columnDefinition = "Geometry(Point, 4326)") // 4326 deals with earth
    private Point dropOffLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rider rider;

    @Enumerated(EnumType.STRING)
    private RideRequestStatus status;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @CreationTimestamp
    private LocalDateTime requestedTime;

    private Double fare;







}
