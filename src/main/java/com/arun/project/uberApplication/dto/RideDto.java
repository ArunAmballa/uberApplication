package com.arun.project.uberApplication.dto;

import com.arun.project.uberApplication.entities.enums.PaymentMethod;
import com.arun.project.uberApplication.entities.enums.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RideDto {


    private Long id;


    private PointDto pickUpLocation;


    private PointDto dropOffLocation;


    private RiderDto rider;


    private DriverDto driver;


    private RideStatus ridestatus;


    private PaymentMethod paymentMethod;


    private LocalDateTime createdTime; // When the driver accepts the ride


    private Double fare;

    private String otp;

    private LocalDateTime startedAt; // When the driver starts the ride

    private LocalDateTime endedAt;
}
