package com.ars.airlinereservationsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "notification")
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "message")
    private String message;
    @Column(name = "date_time")
    private LocalDateTime localDateTime;
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;
    @ManyToOne
    @JoinColumn(name = "cancel_flight_id")
    private CancelFlight cancelFlight;
}