package com.ars.airlinereservationsystem.controller;

import com.ars.airlinereservationsystem.dto.RoleDTO;
import com.ars.airlinereservationsystem.service.implementation.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    private final RoleServiceImpl roleService;
    @Autowired
    public  RoleController(RoleServiceImpl roleService){
        this.roleService=roleService;
    }
    @PostMapping("/add-role")
    public ResponseEntity<RoleDTO> addRole(@RequestBody RoleDTO roleDTO ){
        RoleDTO roleDTO1=roleService.addRole(roleDTO);
        return new ResponseEntity<RoleDTO>(roleDTO1, HttpStatus.CREATED);
    }
    @GetMapping("/get-all-roles")
    public ResponseEntity<List<RoleDTO>> getAllRoles(){
        List<RoleDTO> roleDTOList=roleService.getAllRole();
        return  new ResponseEntity<List<RoleDTO>>(roleDTOList,HttpStatus.FOUND);
    }
    @DeleteMapping("/delete-role")
    public ResponseEntity<RoleDTO> deleteRole(@RequestParam String roleName){
        roleService.deleteRole(roleName);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/update-role")
    public ResponseEntity<RoleDTO> updateRole(@RequestBody RoleDTO roleDTO){

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
