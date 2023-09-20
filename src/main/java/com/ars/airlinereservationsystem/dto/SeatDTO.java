package com.ars.airlinereservationsystem.dto;

import com.ars.airlinereservationsystem.model.util.TravelClass;
import lombok.Data;

@Data
public class SeatDTO {
    private Long seatNo;
    private TravelClass travelClass;
    private double price;
    private boolean availableStatus;
}
