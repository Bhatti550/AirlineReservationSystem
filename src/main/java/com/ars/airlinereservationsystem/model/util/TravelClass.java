package com.ars.airlinereservationsystem.model.util;

public enum TravelClass {
    ECONOMY("Economy Class"),
    BUSINESS("Business Class");
    private final String value;

    TravelClass(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
