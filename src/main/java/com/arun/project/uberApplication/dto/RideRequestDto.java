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

    private PointDto pickUpLocation;  //userInput

    private PointDto dropOffLocation; //userInput

    private PaymentMethod paymentMethod; //userInput

    private RiderDto rider;

    private RideRequestStatus status;

    private Double fare;

    private LocalDateTime requestedTime;
}
