package com.dwp.codechallenge.apicoordinates.model;

public class User {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String ip_address;
    private double latitude;
    private double longitude;

    public User(int id, String first_name, String last_name, String email, String ip_address, double latitude, double longitude) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.ip_address = ip_address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }


    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }


    public String getEmail() {
        return email;
    }

    public String getIp_address() {
        return ip_address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String toString(){
        return String.format("id- %d, first name- %s, last name- %s, email- %s,ip_address- %s, latitude- %f, longitude- %f",id,first_name,last_name,email,ip_address,latitude,longitude);
    }

}
