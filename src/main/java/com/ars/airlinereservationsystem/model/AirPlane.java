package com.ars.airlinereservationsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "airplane")
@Data
public class AirPlane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "airplane_no")
    private  String airPlaneNo;
    @OneToMany(mappedBy = "airPlane")
    private List<Schedule> scheduleList;
    @OneToMany(mappedBy = "airPlane")
    private List<Seat> seatList;
    @ManyToOne
    @JoinColumn(name = "airline_company_id")
    private AirlineCompany airlineCompany;

}
