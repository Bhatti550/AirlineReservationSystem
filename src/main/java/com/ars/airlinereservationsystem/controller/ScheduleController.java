package com.ars.airlinereservationsystem.controller;

import com.ars.airlinereservationsystem.dto.ScheduleDTO;
import com.ars.airlinereservationsystem.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;
    public ScheduleController(ScheduleService scheduleService){
        this.scheduleService=scheduleService;
    }
    @PostMapping("/admin/add")
    public ResponseEntity<ScheduleDTO> addSchedule(@RequestBody ScheduleDTO scheduleDTO){
        ScheduleDTO scheduleDTO1=scheduleService.addSchedule(scheduleDTO);
        return new ResponseEntity<ScheduleDTO>(scheduleDTO1, HttpStatus.CREATED);
    }
    @PutMapping("/admin/update")
    public ResponseEntity<ScheduleDTO> updateSchedule(@RequestBody ScheduleDTO scheduleDTO){
        ScheduleDTO scheduleDTO1=scheduleService.updateSchedule(scheduleDTO);
        return new ResponseEntity<ScheduleDTO>(scheduleDTO1, HttpStatus.ACCEPTED
        );
    }
    @DeleteMapping("/admin/delete")
    public ResponseEntity<ScheduleDTO> addSchedule(@RequestParam Long id){
        ScheduleDTO scheduleDTO=scheduleService.deleteSchedule(id);
        return new ResponseEntity<ScheduleDTO>(scheduleDTO, HttpStatus.OK);
    }
    @GetMapping("/get-by-flight")
    public ResponseEntity<List<ScheduleDTO>> getScheduleByFlightId(@RequestParam Long id){
        List<ScheduleDTO> scheduleDTOList=scheduleService.getScheduleByFlight(id);
        return new ResponseEntity<List<ScheduleDTO>>(scheduleDTOList,HttpStatus.FOUND);
    }
    @GetMapping("/get")
    public ResponseEntity<ScheduleDTO> getSchedule(@RequestParam Long id){
        ScheduleDTO scheduleDTO=scheduleService.getSchedule(id);
        return new ResponseEntity<ScheduleDTO>(scheduleDTO,HttpStatus.FOUND);
    }
    @GetMapping("/get-by-date-time")
    public ResponseEntity<List<ScheduleDTO>> getScheduleByDateTime(@RequestParam LocalDateTime departureTime,@RequestParam LocalDateTime arrivalTime){
        List<ScheduleDTO> scheduleDTOList=scheduleService.getScheduleByDepartureDateTimeAndArrivalDateTime(departureTime,arrivalTime);
        return new ResponseEntity<List<ScheduleDTO>>(scheduleDTOList,HttpStatus.FOUND);
    }
}
