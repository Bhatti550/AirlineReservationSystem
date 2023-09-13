package com.ars.airlinereservationsystem.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RoleDTO {
    private UUID id;
    private String roleName;
}
