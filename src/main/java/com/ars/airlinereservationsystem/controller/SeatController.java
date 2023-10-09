package com.ars.airlinereservationsystem.controller;

import com.ars.airlinereservationsystem.dto.SeatDTO;
import com.ars.airlinereservationsystem.model.util.TravelClass;
import com.ars.airlinereservationsystem.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seat")
public class SeatController {

    private final SeatService seatService;
    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }
    @PostMapping("/admin/add")
    public ResponseEntity<SeatDTO> addSeat(@RequestBody SeatDTO seatDTO){
        SeatDTO seatDTO1=seatService.addSeat(seatDTO);
        return new ResponseEntity<SeatDTO>(seatDTO1, HttpStatus.CREATED);
    }
    @PutMapping("/admin/update")
    public ResponseEntity<SeatDTO> updateSeat(@RequestBody SeatDTO seatDTO){
        SeatDTO seatDTO1=seatService.updateSeat(seatDTO);
        return new ResponseEntity<SeatDTO>(seatDTO1, HttpStatus.ACCEPTED);
    }
    @GetMapping("/get")
    public ResponseEntity<SeatDTO> getSeat(@RequestParam int seatNo){
        SeatDTO seatDTO=seatService.getSeat(seatNo);
        return new ResponseEntity<SeatDTO>(seatDTO,HttpStatus.FOUND);
    }
    @GetMapping("/get-by-price")
    public ResponseEntity<List<SeatDTO>> getSeatByPrice(@RequestParam double startPrice, @RequestParam  double endPrice ){
        List<SeatDTO> seatDTOList=seatService.getSeatByPrice(startPrice,endPrice);
        return new ResponseEntity<List<SeatDTO>>(seatDTOList,HttpStatus.FOUND);
    }
    @GetMapping("/get-by-travel-class")
    public ResponseEntity<List<SeatDTO>> getSeatByTravelClass(@RequestParam TravelClass travelClass ){
        List<SeatDTO> seatDTOList=seatService.getSeatByTravelClass(travelClass);
        return new ResponseEntity<List<SeatDTO>>(seatDTOList,HttpStatus.FOUND);
    }
    @GetMapping("/get-by-status")
    public ResponseEntity<List<SeatDTO>> getSeatByStatus(@RequestParam boolean seatStatus){
        List<SeatDTO> seatDTOList=seatService.getSeatByStatus(seatStatus);
        return new ResponseEntity<List<SeatDTO>>(seatDTOList,HttpStatus.FOUND);
    }
    @DeleteMapping("/admin/delete")
    public ResponseEntity<SeatDTO> deleteSeat(@RequestParam int seatNo){
        SeatDTO seatDTO=seatService.deleteSeat(seatNo);
        return new ResponseEntity<SeatDTO>(seatDTO,HttpStatus.FOUND);
    }
    @GetMapping("/get-all-seats")
    public ResponseEntity<List<SeatDTO>> geAllSeat(){
        List<SeatDTO> seatDTOList=seatService.getAllSeat();
        return new ResponseEntity<List<SeatDTO>>(seatDTOList,HttpStatus.FOUND);
    }
}
