package com.ars.airlinereservationsystem.dto;

import com.ars.airlinereservationsystem.model.AirPlane;
import com.ars.airlinereservationsystem.model.Flight;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScheduleDTO {
    private Long id;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Flight flight;
    private AirPlane airPlane;
}
