package com.ars.airlinereservationsystem.dto;


import com.ars.airlinereservationsystem.model.BookTicket;
import com.ars.airlinereservationsystem.model.UserRole;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class PaymentDTO {
    private Long id;
    private float amount;
    private LocalDateTime date;
    private boolean paymentStatus;
    private BookTicket bookTicket;
    private UserRole userRole;
}
