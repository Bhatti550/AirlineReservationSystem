package com.ars.airlinereservationsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user_role")
@Data
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "userRole")
    private List<Flight> flightList;

    @OneToMany(mappedBy = "userRole")
    private List<Ticket> ticketList;

    @OneToMany(mappedBy = "userRole")
    private List<Airline> airlineList;

    @OneToMany(mappedBy = "userRole")
    private List<CancelFlight> cancelFlightList;

    @OneToMany(mappedBy = "userRole")
    private List<UserNotification> userNotificationList;

}
