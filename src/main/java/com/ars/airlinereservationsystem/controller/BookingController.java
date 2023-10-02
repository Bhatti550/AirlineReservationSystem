package com.ars.airlinereservationsystem.controller;

import com.ars.airlinereservationsystem.dto.BookingDTO;
import com.ars.airlinereservationsystem.model.util.TravelClass;
import com.ars.airlinereservationsystem.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;
    public BookingController(BookingService bookingService){
        this.bookingService=bookingService;
    }
    @PostMapping("/add")
    public ResponseEntity<BookingDTO> addBooking(@RequestBody BookingDTO bookingDTO){
        BookingDTO bookingDTO1=bookingService.addBooking(bookingDTO);
        return new ResponseEntity<BookingDTO>(bookingDTO1, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<BookingDTO> updateBooking(@RequestBody BookingDTO bookingDTO){
        BookingDTO bookingDTO1=bookingService.updateBooking(bookingDTO);
        return new ResponseEntity<BookingDTO>(bookingDTO1, HttpStatus.CREATED);
    }
    @DeleteMapping("/cancel")
    public ResponseEntity<BookingDTO> cancelBooking(@RequestParam Long id){
        BookingDTO bookingDTO=bookingService.cancelBooking(id);
        return new ResponseEntity<BookingDTO>(bookingDTO, HttpStatus.OK);
    }
    @GetMapping("/get-user-booking")
    public ResponseEntity<List<BookingDTO>> getUserBooking(@RequestParam Long userId){
        List<BookingDTO> bookingDTOList=bookingService.getUserBooking(userId);
        return new ResponseEntity<List<BookingDTO>>(bookingDTOList,HttpStatus.FOUND);
    }
    @GetMapping("/get-user-booking-by-date")
    public ResponseEntity<List<BookingDTO>> getUserBookingByDate(@RequestParam Long id,@RequestParam LocalDateTime dateTime){
        List<BookingDTO> bookingDTOList=bookingService.getUserBookingByDateTime(id,dateTime);
        return new ResponseEntity<List<BookingDTO>>(bookingDTOList,HttpStatus.FOUND);
    }
    @GetMapping("/get-booking-by-date")
    public ResponseEntity<List<BookingDTO>> getBookingByDateTime(@RequestParam LocalDateTime dateTime){
        List<BookingDTO> bookingDTOList=bookingService.getBookingByDateTime(dateTime);
        return new ResponseEntity<List<BookingDTO>>(bookingDTOList,HttpStatus.FOUND);
    }
    @GetMapping("/get-booking-by-schedule")
    public ResponseEntity<List<BookingDTO>> getBookingBySchedule(@RequestParam Long id){
        List<BookingDTO> bookingDTOList=bookingService.getBookingBySchedule(id);
        return new ResponseEntity<List<BookingDTO>>(bookingDTOList,HttpStatus.FOUND);
    }
    @GetMapping("/get-booking-by-flight")
    public ResponseEntity<List<BookingDTO>> getBookingByFlight(@RequestParam String flightCode){
        List<BookingDTO> bookingDTOList=bookingService.getBookingByFlight(flightCode);
        return new ResponseEntity<List<BookingDTO>>(bookingDTOList,HttpStatus.FOUND);
    }
    @GetMapping("/get-booking-by-travel-class")
    public ResponseEntity<List<BookingDTO>> getBookingByTravelClass(@RequestParam TravelClass travelClass){
        List<BookingDTO> bookingDTOList=bookingService.getBookingByTravelClass(travelClass);
        return new ResponseEntity<List<BookingDTO>>(bookingDTOList,HttpStatus.FOUND);
    }
    @GetMapping("/get-user-booking-by-seat")
    public ResponseEntity<List<BookingDTO>> getBookingBySeat(@RequestParam Long seatId){
        List<BookingDTO> bookingDTOList=bookingService.getBookingBySeat(seatId);
        return new ResponseEntity<List<BookingDTO>>(bookingDTOList,HttpStatus.FOUND);
    }
}
