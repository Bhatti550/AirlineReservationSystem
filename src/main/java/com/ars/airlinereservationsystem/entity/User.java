package com.ars.airlinereservationsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
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
}
