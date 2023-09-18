package com.ars.airlinereservationsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "amount")
    private float amount;
    @Column(name = "date_time")
    private LocalDateTime date;
    @Column(name = "payment_status")
    private boolean paymentStatus;
    @OneToOne
    @JoinColumn(name = "ticket_id")
    private BookTicket bookTicket;
    @OneToOne(mappedBy = "payment")
    private Notification notification;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
