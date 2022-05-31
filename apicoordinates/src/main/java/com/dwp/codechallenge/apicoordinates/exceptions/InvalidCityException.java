package com.dwp.codechallenge.apicoordinates.exceptions;

public class InvalidCityException extends RuntimeException {
    public InvalidCityException(String errorMessage){
        super(errorMessage);
    }
}
