package com.ars.airlinereservationsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "role",nullable = false,unique = true)
    private String roleName;
    @OneToMany(mappedBy = "role")
    private List<Role> roleList;
}
