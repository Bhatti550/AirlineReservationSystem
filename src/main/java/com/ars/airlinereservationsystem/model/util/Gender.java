package com.ars.airlinereservationsystem.model.util;

public enum Gender {
    MALE("M"),
    FEMALE("F"),
    OTHER("Other");


    private final String  value;
    Gender(String value){
        this.value=value;
    }
    @Override
    public String toString() {
        return value;
    }

}
