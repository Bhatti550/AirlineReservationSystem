package com.ars.airlinereservationsystem.dto;

import com.ars.airlinereservationsystem.model.AirlineCompany;
import lombok.Data;

@Data
public class RouteDTO {
    private Long id;
    private String departureLocation;
    private String destinationLocation;
    private AirlineCompany airlineCompany;
}
