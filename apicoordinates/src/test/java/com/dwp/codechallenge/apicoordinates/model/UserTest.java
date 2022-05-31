package com.dwp.codechallenge.apicoordinates.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user;

    @BeforeEach
    public void setup(){
        user =new User(400,"Robb","Stark","robb.stark@areess.com","100.19976",15.45033,44.12768);
    }

    @Test
    public void testgetFirst_Name(){
        assertEquals("Robb",user.getFirst_name());
    }

    @Test
    public void testgetLast_Name(){
        assertEquals("Stark",user.getLast_name());
    }

    @Test
    public void testIp_address(){
        assertEquals("100.19976",user.getIp_address());
    }

    @Test
    public void testgetId(){
        assertEquals(400,user.getId());
    }

    @Test
    public void testgetLatitude(){
        assertEquals(15.45033,user.getLatitude());
    }

    @Test
    public void testgetName(){
        assertEquals(44.12768,user.getLongitude());
    }


    @Test
    public void testgetEmail(){
        assertEquals("robb.stark@areess.com",user.getEmail());
    }


}
