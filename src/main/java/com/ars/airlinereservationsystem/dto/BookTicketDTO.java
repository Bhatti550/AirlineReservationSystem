package com.ars.airlinereservationsystem.dto;

import lombok.Data;

@Data
public class BookTicketDTO {
    private Long id;
    private Integer numberOfPassenger;
    private Float totalFare;

}
