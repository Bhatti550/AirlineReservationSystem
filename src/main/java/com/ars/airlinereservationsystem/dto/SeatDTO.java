package com.ars.airlinereservationsystem.dto;

import com.ars.airlinereservationsystem.model.AirPlane;
import com.ars.airlinereservationsystem.model.util.TravelClass;
import lombok.Data;

@Data
public class SeatDTO {
    private int seatNo;
    private TravelClass travelClass;
    private double price;
    private AirPlane airPlane;
    private boolean availableStatus;

}
