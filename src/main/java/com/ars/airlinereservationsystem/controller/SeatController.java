package com.ars.airlinereservationsystem.controller;

import com.ars.airlinereservationsystem.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seat")
public class SeatController {

    private SeatService service;
    @Autowired
    public SeatController(SeatService service) {
        this.service = service;
    }
}
