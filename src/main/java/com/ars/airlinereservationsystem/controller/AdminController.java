package com.ars.airlinereservationsystem.controller;

import com.ars.airlinereservationsystem.dto.UserDTO;
import com.ars.airlinereservationsystem.service.implementation.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminServiceImpl adminService;
    @Autowired
    AdminController(AdminServiceImpl adminService){
        this.adminService=adminService;
    }
    @PostMapping("/sign-up")
    public ResponseEntity<UserDTO> signUp(@RequestBody UserDTO userDTO){
        UserDTO userDTO1=adminService.signup(userDTO);
        return new ResponseEntity<UserDTO>(userDTO1, HttpStatus.CREATED);
    }
    @GetMapping("/get-users")
    public ResponseEntity<UserDTO> getAllUsers(){
        List<UserDTO> userDTOList=adminService.getAllUsers();
        return new ResponseEntity<UserDTO>((UserDTO) userDTOList,HttpStatus.FOUND);
    }
}
