package com.ars.airlinereservationsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;
@Entity
@Table(name = "user_notification")
@Data
public class UserNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;
    @ManyToOne
    @JoinColumn(name = "notification_id")
    private Notification notification;
}
