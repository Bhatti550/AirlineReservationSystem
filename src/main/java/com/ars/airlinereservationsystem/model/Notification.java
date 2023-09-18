package com.ars.airlinereservationsystem.model;

import com.ars.airlinereservationsystem.model.util.NotificationType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "notification")
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "message")
    private String message;
    @Column(name = "date_time")
    private LocalDateTime localDateTime;
    @Enumerated(EnumType.STRING)
    @Column(name = "notification_type")
    private NotificationType notificationType;
    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "cancel_flight_id")
    private CancelFlight cancel_flight;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;
}