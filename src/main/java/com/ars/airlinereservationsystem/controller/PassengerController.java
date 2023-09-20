package com.ars.airlinereservationsystem.controller;

import com.ars.airlinereservationsystem.dto.UserDTO;
import com.ars.airlinereservationsystem.service.implementation.PassengerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
    private final PassengerServiceImpl passengerService;
    PassengerController(PassengerServiceImpl passengerService){
        this.passengerService=passengerService;
    }
    @PostMapping("/sign-up")
    public ResponseEntity<UserDTO> signUp(@RequestBody UserDTO userDTO){
        UserDTO userDTO1=passengerService.signup(userDTO);
        return new ResponseEntity<UserDTO>(userDTO1, HttpStatus.CREATED);
    }

}
