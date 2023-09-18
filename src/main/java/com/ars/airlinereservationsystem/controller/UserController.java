package com.ars.airlinereservationsystem.controller;

import com.ars.airlinereservationsystem.dto.UserDTO;
import com.ars.airlinereservationsystem.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;
    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @PostMapping("/create-user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO userDTO1= userService.createUser(userDTO);
        return new ResponseEntity<UserDTO>(userDTO1,HttpStatus.CREATED);
    }
    @GetMapping("/get-all-users")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> userDTOList;
       userDTOList=userService.getAllUsers();
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

}
