package com.ars.airlinereservationsystem.model.util;

public enum FlightClass {
    BUSINESS("Business Class"),
    ECONOMY("Economy Class");
    private final String value;

    FlightClass(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
