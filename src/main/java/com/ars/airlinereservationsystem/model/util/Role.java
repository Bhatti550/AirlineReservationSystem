package com.ars.airlinereservationsystem.model.util;


public enum Role {
    PASSENGER("P"),
    ADMIN("A");
    private final String value;
    Role(String value){
        this.value=value;
    }

    @Override
    public String toString() {
        return value;
    }
}
