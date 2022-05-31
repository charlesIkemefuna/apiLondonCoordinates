package com.dwp.codechallenge.apicoordinates.constants;

public class LondonCoordinates {
    public static final double latitudeCoordinateForLondon = 51 + (30 / 60.0) + (26 / 60.0 / 60.0);
    public static final double longitudeCoordinateForLondon =  0 - (7 / 60.0) - (39 / 60.0 / 60.0);

    public static double getLatitudeCoordinateForLondon() {
        return latitudeCoordinateForLondon;
    }

    public static double getLongitudeCoordinateForLondon() {
        return longitudeCoordinateForLondon;
    }
}
