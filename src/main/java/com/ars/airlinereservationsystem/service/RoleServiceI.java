package com.ars.airlinereservationsystem.service;

import com.ars.airlinereservationsystem.dto.RoleDTO;
import com.ars.airlinereservationsystem.model.Role;

import java.util.List;

public interface RoleServiceI {
    void deleteRole(String roleName);
    List<RoleDTO> getAllRole();
   RoleDTO addRole(RoleDTO roleDTO);
   RoleDTO updateRole(RoleDTO roleDTO);
}
