package com.arun.project.uberApplication.services.implementation;

import com.arun.project.uberApplication.services.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;


@Service
public class OSRMDistanceServiceImplementation implements DistanceService {
    @Override
    public Double calculateDistance(Point src, Point dst) {
        return 0.0;
    }
}
