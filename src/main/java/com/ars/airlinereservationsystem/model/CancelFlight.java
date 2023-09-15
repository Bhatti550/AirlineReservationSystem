package com.ars.airlinereservationsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cancel_flight")
@Data
public class CancelFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "cancel_reason")
    private String cancellationReason;
    @Column(name = "date_time")
    private LocalDateTime date;
    @OneToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @OneToMany(mappedBy = "cancel_flight")
    private List<Notification> notificationList;
    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;
}
