package com.ars.airlinereservationsystem.dto;

import com.ars.airlinereservationsystem.model.User;
import com.ars.airlinereservationsystem.model.Schedule;
import com.ars.airlinereservationsystem.model.Seat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingDTO {
    private Long id;
    private LocalDateTime localDateTime;
    private User passenger;
    private Schedule schedule;
    private Seat seat;

}
