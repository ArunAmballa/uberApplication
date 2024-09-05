package com.arun.project.uberApplication.dto;

import com.arun.project.uberApplication.entities.Rider;
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


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDto {

    private Long id;

    private Point pickUpLocation;

    private Point dropOffLocation;

    private RiderDto rider;

    private RideRequestStatus status;

    private PaymentMethod paymentMethod;

    private LocalDateTime requestedTime;
}
