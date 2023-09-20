package com.ars.airlinereservationsystem.dto;

import lombok.Data;

@Data
public class AirlineDTO {
    private Long id;
    private String name;
    private Long contactNumber;
    private String location;
}
