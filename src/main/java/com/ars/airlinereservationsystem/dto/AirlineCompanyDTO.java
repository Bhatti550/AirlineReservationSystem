package com.ars.airlinereservationsystem.dto;

import lombok.Data;

@Data
public class AirlineCompanyDTO {
    private Long id;
    private String name;
    private String email;
    private Long contactNumber;
    private String location;
}
