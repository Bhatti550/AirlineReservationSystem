package com.ars.airlinereservationsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "airline_company")
@Data
public class AirlineCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name",nullable = false,unique = true)
    private String name;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "contact_number", unique = true, length = 13)
    private Long number;
    @Column(name = "location")
    private String location;
    @OneToMany(mappedBy = "airlineCompany")
    private List<AirPlane> airPlaneList;
    @OneToMany(mappedBy = "airlineCompany")
    private List<Route> routeList;
}
