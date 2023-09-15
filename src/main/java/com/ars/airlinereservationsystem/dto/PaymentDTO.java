package com.ars.airlinereservationsystem.dto;

import com.ars.airlinereservationsystem.model.Ticket;
import com.ars.airlinereservationsystem.model.UserRole;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PaymentDTO {
    private UUID id;
    private float amount;
    private LocalDateTime date;
    private boolean paymentStatus;
    private Ticket ticket;
    private UserRole userRole;
}
