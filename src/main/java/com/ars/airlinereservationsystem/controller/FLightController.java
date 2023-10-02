package com.ars.airlinereservationsystem.controller;

import com.ars.airlinereservationsystem.dto.FlightDTO;
import com.ars.airlinereservationsystem.model.Route;
import com.ars.airlinereservationsystem.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FLightController {
    private final FlightService flightService;
    public FLightController(FlightService flightService){
        this.flightService=flightService;
    }
    @PostMapping("/admin/add")
    public ResponseEntity<FlightDTO> addFlight(@RequestBody FlightDTO flightDTO){
        FlightDTO flightDTO1=flightService.addFlight(flightDTO);
        return new ResponseEntity<FlightDTO>(flightDTO1, HttpStatus.CREATED);
    }
    @PutMapping("/admin/update")
    public ResponseEntity<FlightDTO> updateFlight(@RequestBody FlightDTO flightDTO){
        FlightDTO flightDTO1=flightService.addFlight(flightDTO);
        return new ResponseEntity<FlightDTO>(flightDTO1, HttpStatus.ACCEPTED);
    }
    @GetMapping("/get")
    public ResponseEntity<FlightDTO> updateFlight(@RequestParam Long id){
        FlightDTO flightDTO=flightService.getFlight(id);
        return new ResponseEntity<FlightDTO>(flightDTO, HttpStatus.FOUND);
    }
    @DeleteMapping("/admin/delete")
    public ResponseEntity<FlightDTO> deleteFlight(@RequestParam String flightCode){
        FlightDTO flightDTO=flightService.deleteFlight(flightCode);
        return new ResponseEntity<FlightDTO>(flightDTO, HttpStatus.OK);
    }
    @GetMapping("/get-by-route")
    public ResponseEntity<List<FlightDTO>> deleteFlight(@RequestParam Route route){
        List<FlightDTO>flightDTOList=flightService.getFlightByRoute(route);
        return new ResponseEntity<List<FlightDTO>>(flightDTOList, HttpStatus.FOUND);
    }

}
