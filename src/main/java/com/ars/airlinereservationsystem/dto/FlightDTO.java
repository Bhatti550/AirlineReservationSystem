package com.ars.airlinereservationsystem.dto;

import com.ars.airlinereservationsystem.model.Airline;
import com.ars.airlinereservationsystem.model.util.FlightClass;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class FlightDTO {
    private UUID id;
    private String departureLocation;
    private String destinationLocation;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int businessClassSeats;
    private int economyClassSeats;
    private double businessClassPrice;
    private double economyClassPrice;
    private FlightClass flightClass;
    private Airline airline;
}
