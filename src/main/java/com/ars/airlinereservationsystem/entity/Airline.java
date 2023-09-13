package com.ars.airlinereservationsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "airline")
@Data
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "name",nullable = false,unique = true)
    private String name;
    @Column(name = "number", length = 12,nullable = false,unique = true)
    private Long contactNumber;
    @OneToMany(mappedBy = "airline")
    private List<Flight> flightList;
}
