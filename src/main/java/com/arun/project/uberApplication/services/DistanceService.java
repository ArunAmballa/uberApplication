package com.arun.project.uberApplication.services;

import org.locationtech.jts.geom.Point;

public interface DistanceService {
    Double calculateDistance(Point src, Point dst);
}
