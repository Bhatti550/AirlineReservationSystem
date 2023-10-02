package com.ars.airlinereservationsystem.dto;

import com.ars.airlinereservationsystem.model.Route;
import com.ars.airlinereservationsystem.model.util.FlightStatus;
import lombok.Data;

@Data
public class FlightDTO {
    private Long id;
    private FlightStatus flightStatus;
    private String flightCode;
    private Route route;
}
