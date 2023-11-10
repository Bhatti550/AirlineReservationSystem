package com.ars.airlinereservationsystem.controller;

import com.ars.airlinereservationsystem.dto.SignInDTO;
import com.ars.airlinereservationsystem.dto.SignUpDTO;
import com.ars.airlinereservationsystem.dto.UserDTO;
import com.ars.airlinereservationsystem.security.auth.AuthenticationResponse;
import com.ars.airlinereservationsystem.security.auth.AuthenticationService;
import com.ars.airlinereservationsystem.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/passengers")
public class PassengerController {
    private final UserServiceImpl passengerService;
    private final AuthenticationService authenticationService;

    @Autowired
    PassengerController(UserServiceImpl adminService,AuthenticationService authenticationService){
        this.passengerService=adminService;
        this.authenticationService=authenticationService;
    }
    @PostMapping
    public ResponseEntity<AuthenticationResponse> register(@RequestBody SignUpDTO request){
        return ResponseEntity.ok(authenticationService.register(request));

    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody SignInDTO request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> userDTOList=passengerService.getAllPassengerUsers();
        return new ResponseEntity<List<UserDTO>>(userDTOList,HttpStatus.FOUND);
    }
    @DeleteMapping("/{email}{password}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable String email, @PathVariable String password){
        UserDTO userDTO=passengerService.deleteUser(email,password);
        return new ResponseEntity<UserDTO>(userDTO,HttpStatus.ACCEPTED);
    }
    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
        UserDTO userDTO1=passengerService.updateUser(userDTO);
        return new ResponseEntity<UserDTO>(userDTO1,HttpStatus.ACCEPTED);
    }
    @GetMapping("/{email}")
    public ResponseEntity<UserDTO> getUser(@RequestParam String email){
        UserDTO userDTO=passengerService.getUser(email);
        return new ResponseEntity<UserDTO>(userDTO,HttpStatus.FOUND);
    }

}
