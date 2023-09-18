package com.ars.airlinereservationsystem.dto;
import lombok.Data;

import java.util.UUID;
@Data
public class AirlineDTO {
    private Long id;
    private String name;
    private Long contactNumber;
}
