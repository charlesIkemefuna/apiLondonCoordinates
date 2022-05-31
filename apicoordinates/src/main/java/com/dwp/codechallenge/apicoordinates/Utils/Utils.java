package com.dwp.codechallenge.apicoordinates.Utils;


import com.dwp.codechallenge.apicoordinates.model.User;
import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;


public class Utils {

    public static double calculate50milesRadiusFromLondon(double latitudeOfLondon, double longitudeOfLondon, double latitudeOfUser, double longitudeOfUser, User user){
        GeodesicData result = Geodesic.WGS84.Inverse(latitudeOfLondon, longitudeOfLondon, latitudeOfUser, longitudeOfUser);
        double distanceInMetres = result.s12;
        double milesConverter = 1609.34;
        double distanceInMiles = distanceInMetres / milesConverter;
        return distanceInMiles;
    }


}
