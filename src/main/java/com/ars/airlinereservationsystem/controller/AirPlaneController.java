package com.ars.airlinereservationsystem.controller;

import com.ars.airlinereservationsystem.dto.AirPlaneDTO;
import com.ars.airlinereservationsystem.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airplane")
public class AirPlaneController {
    private final AirplaneService airplaneService;
    @Autowired
    AirPlaneController(AirplaneService airplaneService){
        this.airplaneService=airplaneService;
    }
    @PostMapping("/add")
    public ResponseEntity<AirPlaneDTO> adAirPlane(@RequestBody AirPlaneDTO airPlaneDTO){
        AirPlaneDTO airPlaneDTO1=airplaneService.addAirplane(airPlaneDTO);
        return new ResponseEntity<AirPlaneDTO>(airPlaneDTO1, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<AirPlaneDTO> updateAirPlane(@RequestBody AirPlaneDTO airPlaneDTO){
        AirPlaneDTO airPlaneDTO1=airplaneService.updateAirplane(airPlaneDTO);
        return new ResponseEntity<AirPlaneDTO>(airPlaneDTO1, HttpStatus.ACCEPTED);
    }
    @GetMapping("/get")
    public ResponseEntity<AirPlaneDTO> getAirPlane(@RequestParam String airPlaneNo){
        AirPlaneDTO airPlaneDTO=airplaneService.getAirPlane(airPlaneNo);
        return new ResponseEntity<AirPlaneDTO>(airPlaneDTO, HttpStatus.FOUND);
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<AirPlaneDTO>> getAllAirPlane(){
        List<AirPlaneDTO> airPlaneDTOList=airplaneService.getAllAirPlanes();
        return new ResponseEntity<List<AirPlaneDTO>>(airPlaneDTOList, HttpStatus.FOUND);
    }
    @PutMapping("/delete")
    public ResponseEntity<AirPlaneDTO> deleteAirPlane(@RequestParam String airPlaneNo){
        AirPlaneDTO airPlaneDTO=airplaneService.deleteAirplane(airPlaneNo);
        return new ResponseEntity<AirPlaneDTO>(airPlaneDTO,HttpStatus.OK);
    }
}
