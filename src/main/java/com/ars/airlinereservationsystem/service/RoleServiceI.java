package com.ars.airlinereservationsystem.service;

import com.ars.airlinereservationsystem.dto.RoleDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoleServiceI {
    RoleDTO deleteRole(String roleName);
    List<RoleDTO> getAllRole();
    ResponseEntity<List<RoleDTO>> addRole(RoleDTO roleDTO);
}
