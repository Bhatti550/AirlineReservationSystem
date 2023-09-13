package com.ars.airlinereservationsystem.entity;

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
    @OneToMany(mappedBy = "user_role")
    private List<Flight> flightList;
    @OneToMany(mappedBy = "user_role")
    private List<Ticket> ticketList;
    @OneToMany(mappedBy = "userRole")
    private List<Payment> payment;

}
