package com.ars.airlinereservationsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "fight")
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "departure_location")
    private String departureLocation;
    @Column(name = "destination_location")
    private String destinationLocation;
    @Column(name = "departure_time")
    private LocalDateTime departureTime;
    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;
    @Column(name = "business_class_seats")
    private int businessClassSeats;
    @Column(name = "economy_class_seats")
    private int economyClassSeats;
    @Column(name = "business_class_price")
    private double businessClassPrice;
    @Column(name = "business_class_price")
    private double economyClassPrice;
    @Enumerated(EnumType.STRING)
    private FlightClass flightClass;
    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;
    @OneToOne(mappedBy = "flight")
    private CancelFlight cancelFlight;
}
