package com.ars.airlinereservationsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "departure_time")
    private LocalDateTime departureTime;
    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;
    @OneToMany(mappedBy = "schedule")
    private List<Booking> bookingList;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private AirPlane airPlane;
}
