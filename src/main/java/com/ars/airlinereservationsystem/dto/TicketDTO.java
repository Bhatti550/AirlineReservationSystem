package com.ars.airlinereservationsystem.dto;

import lombok.Data;

import java.util.UUID;
@Data
public class TicketDTO {
    private UUID id;
    private Integer numberOfPassenger;
    private Float totalFare;

}
