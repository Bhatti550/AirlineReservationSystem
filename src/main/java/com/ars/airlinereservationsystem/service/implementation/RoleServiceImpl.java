package com.ars.airlinereservationsystem.service.implementation;

import com.ars.airlinereservationsystem.dto.RoleDTO;
import com.ars.airlinereservationsystem.exception.CustomServiceException;
import com.ars.airlinereservationsystem.model.Role;
import com.ars.airlinereservationsystem.repository.RoleRepository;
import com.ars.airlinereservationsystem.service.RoleServiceI;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleServiceI {

    private  final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository,ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public RoleDTO updateRole(RoleDTO roleDTO) {
        Long dtoRoleID=roleDTO.getId();
        Role role=roleRepository.findRoleById(dtoRoleID);
        if(role!=null) {
            role.setRoleName(roleDTO.getRoleName());
            roleRepository.save(role);
            RoleDTO roleDTO1=this.modelMapper.map(role,RoleDTO.class);
            return roleDTO1;
        }
        else {
            throw new CustomServiceException(404, "Role Not Against your Input Data.");
        }
    }

    @Override
    public void deleteRole(String roleName) {
        Role role=roleRepository.findRoleByRoleName(roleName);
        if (role!=null) {
            roleRepository.deleteRoleByRoleName(roleName);
        }
        else {
            throw new CustomServiceException(404,"Role Not Against your Input Data.");
        }
    }

    @Override
    public List<RoleDTO> getAllRole() {
        List<Role> roleList=roleRepository.findAll();
        Type listType = new TypeToken<List<RoleDTO>>() {}.getType();
        List<RoleDTO> roleDTOList = modelMapper.map(roleList, listType);
        return roleDTOList;
    }

    @Override
    public RoleDTO addRole(RoleDTO roleDTO) {
        Role role=this.modelMapper.map(roleDTO, Role.class);
        roleRepository.save(role);
        if (role!=null){
            RoleDTO roleDTO1=this.modelMapper.map(role,RoleDTO.class);
            return  roleDTO1;
        }
        else {
            throw  new CustomServiceException(400,"Data not Save");
        }
    }
}
