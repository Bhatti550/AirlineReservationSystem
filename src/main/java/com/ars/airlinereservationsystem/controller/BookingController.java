package com.ars.airlinereservationsystem.controller;

import com.ars.airlinereservationsystem.dto.BookingDTO;
import com.ars.airlinereservationsystem.exception.CustomControllerException;
import com.ars.airlinereservationsystem.model.util.TravelClass;
import com.ars.airlinereservationsystem.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/bookings")
public class BookingController {
    private final BookingService bookingService;
    public BookingController(BookingService bookingService){
        this.bookingService=bookingService;
    }
    @PostMapping
    public ResponseEntity<BookingDTO> addBooking(@RequestBody BookingDTO bookingDTO){
        try {
            BookingDTO bookingDTO1=bookingService.addBooking(bookingDTO);
            return new ResponseEntity<BookingDTO>(bookingDTO1, HttpStatusCode.valueOf(201));
        }
        catch (CustomControllerException cce){
            throw new CustomControllerException(406,"Not Acceptable");
        }

    }
    @PutMapping
    public ResponseEntity<BookingDTO> updateBooking(@RequestBody BookingDTO bookingDTO){
        BookingDTO bookingDTO1=bookingService.updateBooking(bookingDTO);
        return new ResponseEntity<BookingDTO>(bookingDTO1, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<BookingDTO> cancelBooking(@PathVariable Long id){
        BookingDTO bookingDTO=bookingService.cancelBooking(id);
        return new ResponseEntity<BookingDTO>(bookingDTO, HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<BookingDTO>> getUserBooking(@PathVariable Long userId){
        List<BookingDTO> bookingDTOList=bookingService.getUserBooking(userId);
        return new ResponseEntity<List<BookingDTO>>(bookingDTOList,HttpStatus.FOUND);
    }
    @GetMapping("/users{id}{dateTime}")
    public ResponseEntity<List<BookingDTO>> getUserBookingByDate(@PathVariable Long id,@PathVariable LocalDateTime dateTime){
        List<BookingDTO> bookingDTOList=bookingService.getUserBookingByDateTime(id,dateTime);
        return new ResponseEntity<List<BookingDTO>>(bookingDTOList,HttpStatus.FOUND);
    }
    @GetMapping("/{dateTime}")
    public ResponseEntity<List<BookingDTO>> getBookingByDateTime(@PathVariable LocalDateTime dateTime){
        List<BookingDTO> bookingDTOList=bookingService.getBookingByDateTime(dateTime);
        return new ResponseEntity<List<BookingDTO>>(bookingDTOList,HttpStatus.FOUND);
    }
    @GetMapping("/schedules{id}")
    public ResponseEntity<List<BookingDTO>> getBookingBySchedule(@PathVariable Long id){
        List<BookingDTO> bookingDTOList=bookingService.getBookingBySchedule(id);
        return new ResponseEntity<List<BookingDTO>>(bookingDTOList,HttpStatus.FOUND);
    }
    @GetMapping("/flights{flightCode}")
    public ResponseEntity<List<BookingDTO>> getBookingByFlight(@PathVariable String flightCode){
        List<BookingDTO> bookingDTOList=bookingService.getBookingByFlight(flightCode);
        return new ResponseEntity<List<BookingDTO>>(bookingDTOList,HttpStatus.FOUND);
    }
    @GetMapping("/{travelClass}")
    public ResponseEntity<List<BookingDTO>> getBookingByTravelClass(@PathVariable TravelClass travelClass){
        List<BookingDTO> bookingDTOList=bookingService.getBookingByTravelClass(travelClass);
        return new ResponseEntity<List<BookingDTO>>(bookingDTOList,HttpStatus.FOUND);
    }
    @GetMapping("/seats{seatId}")
    public ResponseEntity<List<BookingDTO>> getBookingBySeat(@PathVariable Long seatId){
        List<BookingDTO> bookingDTOList=bookingService.getBookingBySeat(seatId);
        return new ResponseEntity<List<BookingDTO>>(bookingDTOList,HttpStatus.FOUND);
    }
}
