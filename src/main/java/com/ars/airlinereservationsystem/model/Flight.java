package com.ars.airlinereservationsystem.model;

import com.ars.airlinereservationsystem.model.util.FlightClass;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "fight")
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
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
    @Column(name = "economy_class_price")
    private double economyClassPrice;
    @Enumerated(EnumType.STRING)
    @Column(name = "flight_class")
    private FlightClass flightClass;
    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;
    @OneToOne(mappedBy = "flight")
    private CancelFlight cancelFlight;
    @OneToMany(mappedBy = "flight")
    private List<BookTicket> bookTickets;
}
