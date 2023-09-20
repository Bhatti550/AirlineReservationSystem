package com.ars.airlinereservationsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "flight_booking")
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
}
