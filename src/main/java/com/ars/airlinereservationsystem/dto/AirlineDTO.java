package com.ars.airlinereservationsystem.dto;
import lombok.Data;

import java.util.UUID;
@Data
public class AirlineDTO {
    private UUID id;
    private String name;
    private Long contactNumber;
}
