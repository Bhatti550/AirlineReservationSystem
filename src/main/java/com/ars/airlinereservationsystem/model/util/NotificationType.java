package com.ars.airlinereservationsystem.model.util;

public enum NotificationType {
    GENERAL("for all users"),
    SPECIFIC("for specific user only");
    private final String value;
     NotificationType(String  value){
        this.value=value;
    }

    @Override
    public String toString() {
        return value;
    }
}
