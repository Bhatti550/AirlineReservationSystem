package com.ars.airlinereservationsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name ="password", nullable = false)
    private String password;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "contact_number",nullable = false,length = 13)
    private Long number;
    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoleList;
    @OneToMany(mappedBy = "user")
    private List<Airline> airlineList;
    @OneToMany(mappedBy = "user")
    private List<BookTicket> bookTicketList;
    @OneToMany(mappedBy = "user")
    private List<Notification> notificationList;

}
