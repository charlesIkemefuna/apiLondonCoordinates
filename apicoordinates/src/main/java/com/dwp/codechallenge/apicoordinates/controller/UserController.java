package com.dwp.codechallenge.apicoordinates.controller;

import com.dwp.codechallenge.apicoordinates.exceptions.InvalidCityException;
import com.dwp.codechallenge.apicoordinates.model.User;
import com.dwp.codechallenge.apicoordinates.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("locationCoordinatorapp")
@RestController
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping("/city/{city}/users")
    public List<User> getUsersInLondon(@PathVariable("city")String city) throws Exception{
        List <User> users = null;
        if (city.equals("London")) {
            users = userService.getUsersThatLiveInLondon();
            logger.info("Processing get request- Getting users " + users.toString());
            return users;
        }else{
            throw new InvalidCityException("Please enter London as city.");
        }
    }

    @GetMapping("/users")
    public List<User> getUsersThatLive50MilesWithinLondon() throws Exception{
        List<User> filteredUsers = userService.filterUkUsersWithin50MilesOfLondon();
        return filteredUsers;
    }

}
