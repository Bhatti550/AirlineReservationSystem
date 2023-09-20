package com.ars.airlinereservationsystem.dto;


import com.ars.airlinereservationsystem.model.Booking;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class PaymentDTO {
    private Long id;
    private float amount;
    private LocalDateTime date;
    private boolean paymentStatus;
    private Booking bookTicket;
}
