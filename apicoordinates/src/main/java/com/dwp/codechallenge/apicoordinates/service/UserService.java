package com.dwp.codechallenge.apicoordinates.service;

import com.dwp.codechallenge.apicoordinates.Utils.Utils;
import com.dwp.codechallenge.apicoordinates.constants.LondonCoordinates;
import com.dwp.codechallenge.apicoordinates.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;

    private User[] arrayOfUsersThatLiveInLondon;

    private  ResponseEntity<User[]> users;

    private List<User> listOfUsersInTheUk;

    private List<User> listOfUsersThatLiveInLondon;

    @Value("${url.for.people.living.in.london}")
    private String urlForPeopleLivingInLondon;


    @Value("${url.for.people.living.in.uk}")
    private String urlForPeopleLivingInUk;


    public List<User> getUsersThatLiveInLondon() throws Exception {
         users =  restTemplate.getForEntity(urlForPeopleLivingInLondon,User[].class);
        if(users!= null){
            arrayOfUsersThatLiveInLondon =users.getBody();
            listOfUsersThatLiveInLondon = Arrays.asList(arrayOfUsersThatLiveInLondon);
        }
        return listOfUsersThatLiveInLondon;
    }


    public List<User> getAllUsers() throws Exception{
       users = restTemplate.getForEntity(urlForPeopleLivingInUk, User[].class);
        if(users!=null){
            listOfUsersInTheUk = Arrays.asList(users.getBody());
        }
        return listOfUsersInTheUk;
    }

    public List<User> filterUkUsersWithin50MilesOfLondon() throws Exception{
        List<User> filteredUkUsersThatLive50milesFromLondon = new ArrayList<>();
        for(User user:getAllUsers()){
            double distanceInMiles = Utils.calculate50milesRadiusFromLondon(LondonCoordinates.latitudeCoordinateForLondon,LondonCoordinates.longitudeCoordinateForLondon,user.getLatitude(),user.getLongitude(),user);
            if(distanceInMiles<=50){
                filteredUkUsersThatLive50milesFromLondon.add(user);
            }
        }
        return filteredUkUsersThatLive50milesFromLondon;
    }

}
