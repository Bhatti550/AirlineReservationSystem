package com.ars.airlinereservationsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payment")
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
    @OneToOne(mappedBy = "payment")
    private Notification notification;

}
