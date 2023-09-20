package com.ars.airlinereservationsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "route")
@Data
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "departure_location")
    private String departureLocation;
    @Column(name = "destination_location")
    private String destinationLocation;
    @ManyToOne
    @JoinColumn(name = "airline_company_id")
    private AirlineCompany airlineCompany;
    @OneToMany(mappedBy = "route")
    private List<Flight> flightList;
}
