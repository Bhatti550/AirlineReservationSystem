package com.ars.airlinereservationsystem.model.util;

public enum FlightStatus {
    ACTIVE("Flight is Active"),
    CANCEL("Flight is  Cancel");
    private final String value;

    FlightStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
