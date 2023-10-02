package com.ars.airlinereservationsystem.controller;

import com.ars.airlinereservationsystem.dto.RouteDTO;
import com.ars.airlinereservationsystem.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/route")
public class RouteController {
    private RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/admin/add")
    public ResponseEntity<RouteDTO> addRoute(@RequestBody RouteDTO routeDTO) {
        RouteDTO routeDTO1 = routeService.addRoute(routeDTO);
        return new ResponseEntity<RouteDTO>(routeDTO1, HttpStatus.CREATED);
    }

    @PutMapping("/admin/update")
    public ResponseEntity<RouteDTO> updateRoute(@RequestBody RouteDTO routeDTO) {
        RouteDTO routeDTO1 = routeService.updateRoute(routeDTO);
        return new ResponseEntity<RouteDTO>(routeDTO1, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-by-airline-company")
    public ResponseEntity<List<RouteDTO>> getRouteByAirlineCompany(@RequestParam String name){
        List<RouteDTO> routeDTOList=routeService.getRoutesByAirlineCompany(name);
        return new ResponseEntity<List<RouteDTO>>(routeDTOList, HttpStatus.FOUND);
    }
    @GetMapping("/get-custom")
    public ResponseEntity<List<RouteDTO>> getCustomRoute(@RequestParam String departureLocation, @RequestParam String destinationLocation){
        List<RouteDTO> routeDTOList=routeService.getCustomRoute(departureLocation,destinationLocation);
        return new ResponseEntity<List<RouteDTO>>(routeDTOList, HttpStatus.FOUND);
    }
    @DeleteMapping("/admin/delete")
    public ResponseEntity<RouteDTO> deleteRoute(@RequestParam Long id){
        RouteDTO routeDTO=routeService.deleteRoute(id);
        return new ResponseEntity<RouteDTO>(routeDTO,HttpStatus.OK);
    }
}

