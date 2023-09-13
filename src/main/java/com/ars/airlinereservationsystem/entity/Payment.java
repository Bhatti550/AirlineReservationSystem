package com.ars.airlinereservationsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "airline")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "amount")
    private float amount;
    @Column(name = "date_time")
    private LocalDateTime date;
    @Column(name = "payment_status")
    private boolean paymentStatus;
    @OneToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;
}
