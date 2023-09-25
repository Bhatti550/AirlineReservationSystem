package com.ars.airlinereservationsystem.model;

import com.ars.airlinereservationsystem.model.util.Gender;
import com.ars.airlinereservationsystem.model.util.Role;
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
    @Enumerated(EnumType.STRING)
    @Column(name = "Gender")
    private Gender gender;
    @Enumerated(EnumType.STRING)
    @Column(name = "Role")
    private Role role=Role.PASSENGER; // Set Default Value for Role.
    @Column(name = "address", length = 200)
    private String address;
    @OneToMany(mappedBy = "user")
    private List<Booking> bookingList;
}
