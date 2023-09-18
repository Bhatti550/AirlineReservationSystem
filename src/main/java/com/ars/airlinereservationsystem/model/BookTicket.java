package com.ars.airlinereservationsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "book_ticket")
@Data
public class BookTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "number_of_passenger")
    private Integer numberOfPassenger;
    @Column(name = "total_fare")
    private Float totalFare;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
    @OneToOne(mappedBy = "bookTicket")
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
