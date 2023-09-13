package com.ars.airlinereservationsystem.dto;

import com.ars.airlinereservationsystem.entity.CancelFlight;
import com.ars.airlinereservationsystem.entity.Ticket;
import com.ars.airlinereservationsystem.entity.UserRole;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
public class NotificationDTO {
    private UUID id;
    private String message;
    private LocalDateTime localDateTime;
    private Ticket ticket;
    private UserRole userRole;
    private CancelFlight cancelFlight;
}
