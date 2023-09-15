package com.ars.airlinereservationsystem.service.implementation;

import com.ars.airlinereservationsystem.dto.RoleDTO;
import com.ars.airlinereservationsystem.model.Role;
import com.ars.airlinereservationsystem.repository.RoleRepository;
import com.ars.airlinereservationsystem.service.RoleServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleServiceI {

    private  final RoleRepository repository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.repository = roleRepository;
    }

    @Override
    public RoleDTO deleteRole(String roleName) {
        return null;
    }

    @Override
    public List<RoleDTO> getAllRole() {
        return null;
    }

    @Override
    public ResponseEntity<List<RoleDTO>> addRole(RoleDTO roleDTO) {
        List<Role> roleList=new ArrayList<>();
        roleDTO.dtoToModel(roleList);
}
