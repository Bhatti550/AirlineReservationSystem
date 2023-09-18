package com.ars.airlinereservationsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role",nullable = false,unique = true)
    private String roleName;
    @OneToMany(mappedBy = "role")
    private List<UserRole> roleList;
}
