package com.ars.airlinereservationsystem.controller;

import com.ars.airlinereservationsystem.dto.AirlineCompanyDTO;
import com.ars.airlinereservationsystem.service.AirlineCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airline-company")
public class AirlineCompanyController {
    private final AirlineCompanyService airlineCompanyService;
    @Autowired
    AirlineCompanyController(AirlineCompanyService airlineCompanyService){
        this.airlineCompanyService=airlineCompanyService;
    }
    @PostMapping("/add")
    private ResponseEntity<AirlineCompanyDTO> addAirlineCompany(@RequestBody AirlineCompanyDTO airlineCompanyDTO){
        AirlineCompanyDTO airlineCompanyDTO1=airlineCompanyService.addAirlineCompany(airlineCompanyDTO);
        return new ResponseEntity<AirlineCompanyDTO>(airlineCompanyDTO1, HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<AirlineCompanyDTO> getAirlineCompany(@RequestParam String name){
        AirlineCompanyDTO airlineCompanyDTO=airlineCompanyService.getAirlineCompany(name);
        return new ResponseEntity<AirlineCompanyDTO>(airlineCompanyDTO,HttpStatus.FOUND);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<AirlineCompanyDTO> deleteAirlineCompany(@RequestParam String name){
        AirlineCompanyDTO airlineCompanyDTO=airlineCompanyService.deleteAirlineCompany(name);
        return new ResponseEntity<AirlineCompanyDTO>(airlineCompanyDTO,HttpStatus.OK);
    }
    @PutMapping("/update")
    public AirlineCompanyDTO updateAirlineCompany(@RequestBody AirlineCompanyDTO airlineCompanyDTO){
        AirlineCompanyDTO airlineCompanyDTO1=airlineCompanyService.updateAirlineCompany(airlineCompanyDTO);
        return new ResponseEntity<AirlineCompanyDTO>(airlineCompanyDTO1,HttpStatus.ACCEPTED).getBody();
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<AirlineCompanyDTO>> getAllAirlineCompanies(){
        List<AirlineCompanyDTO> airlineCompanyDTOList=airlineCompanyService.getAllAirlineCompany();
        return new ResponseEntity<List<AirlineCompanyDTO>>(airlineCompanyDTOList,HttpStatus.FOUND);
    }

}
