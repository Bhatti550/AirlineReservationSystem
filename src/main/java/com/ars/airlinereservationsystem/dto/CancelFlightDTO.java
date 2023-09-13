package com.ars.airlinereservationsystem.dto;

import com.ars.airlinereservationsystem.entity.Flight;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
public class CancelFlightDTO {
    private UUID id;
    private String cancellationReason;
    private LocalDateTime date;
    private Flight flight;
}
