package com.ars.airlinereservationsystem.controller;

import com.ars.airlinereservationsystem.dto.UserDTO;
import com.ars.airlinereservationsystem.service.implementation.PassengerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/get-all-users")
    public ResponseEntity<UserDTO> getAllUsers(){
        List<UserDTO> userDTOList=passengerService.getAllUsers();
        return new ResponseEntity<UserDTO>((UserDTO) userDTOList,HttpStatus.FOUND);
    }
    @DeleteMapping("/delete-user")
    public ResponseEntity<UserDTO> deleteUser(@RequestParam String email, @RequestParam String password){
        UserDTO userDTO=passengerService.deleteUser(email,password);
        return new ResponseEntity<UserDTO>(userDTO,HttpStatus.ACCEPTED);
    }
    @PutMapping("/update-user")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
        UserDTO userDTO1=passengerService.updateUser(userDTO);
        return new ResponseEntity<UserDTO>(userDTO1,HttpStatus.ACCEPTED);
    }
    @GetMapping("/get-user")
    public ResponseEntity<UserDTO> getUser(@RequestParam String email){
        UserDTO userDTO=passengerService.getUser(email);
        return new ResponseEntity<UserDTO>(userDTO,HttpStatus.FOUND);
    }

}
