package com.ars.airlinereservationsystem.dto;

import com.ars.airlinereservationsystem.model.BookTicket;
import com.ars.airlinereservationsystem.model.CancelFlight;
import com.ars.airlinereservationsystem.model.UserRole;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
public class NotificationDTO {
    private Long id;
    private String message;
    private LocalDateTime localDateTime;
    private BookTicket bookTicket;
    private UserRole userRole;
    private CancelFlight cancelFlight;
}
