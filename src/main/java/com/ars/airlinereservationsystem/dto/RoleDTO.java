package com.ars.airlinereservationsystem.dto;

import com.ars.airlinereservationsystem.model.Role;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Data
public class RoleDTO {
    private UUID id;
    private String roleName;
    @Autowired
    private ModelMapper modelMapper;
    public Role dtoToModel(RoleDTO roleDTO){
        Role role=this.modelMapper.map(roleDTO, Role.class);
        return  role;
    }
    public RoleDTO modelToDto(Role role){
        RoleDTO roleDTO=this.modelMapper.map(role,RoleDTO.class);
        return  roleDTO;
    }
}
