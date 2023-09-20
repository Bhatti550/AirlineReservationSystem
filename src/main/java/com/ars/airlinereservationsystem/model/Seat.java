package com.ars.airlinereservationsystem.model;

import com.ars.airlinereservationsystem.model.util.TravelClass;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "seat")
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "seat_no")
    private int seatNo;
    @Enumerated(EnumType.STRING)
    @Column(name = "travel_class")
    private TravelClass travelClass;
    @Column(name = "price")
    private double price;
    @Column(name = "available")
    private boolean availableStatus;
    @OneToMany(mappedBy = "seat")
    private List<Booking> bookingList;
    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private AirPlane airPlane;
}
