package com.ars.airlinereservationsystem.model;

import com.ars.airlinereservationsystem.model.util.NotificationType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
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
    @Enumerated(EnumType.STRING)
    @Column(name = "notification_type")
    private NotificationType notificationType;
    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "cancel_flight_id")
    private CancelFlight cancel_flight;
    @OneToMany(mappedBy = "notification")
    private List<UserNotification> userNotificationList;
}