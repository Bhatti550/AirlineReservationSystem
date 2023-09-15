package com.ars.airlinereservationsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "number_of_passenger")
    private Integer numberOfPassenger;
    @Column(name = "total_fare")
    private Float totalFare;
    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
    @OneToOne(mappedBy = "ticket")
    private Payment payment;
}
