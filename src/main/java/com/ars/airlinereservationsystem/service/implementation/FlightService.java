package com.ars.airlinereservationsystem.service.implementation;
import com.ars.airlinereservationsystem.dto.FlightDTO;
import com.ars.airlinereservationsystem.repository.BookingRepository;
import com.ars.airlinereservationsystem.repository.FlightBookingRepository;
import com.ars.airlinereservationsystem.repository.FlightRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    private final BookingRepository bookingRepository;
    private final FlightBookingRepository flightBookingRepository;
    private final ModelMapper modelMapper;

    @Autowired
    FlightService(FlightRepository flightRepository,BookingRepository bookingRepository,ModelMapper modelMapper,FlightBookingRepository flightBookingRepository){
        this.flightRepository=flightRepository;
        this.bookingRepository=bookingRepository;
        this.modelMapper=modelMapper;
        this.flightBookingRepository=flightBookingRepository;
    }
    public FlightDTO addFlight(FlightDTO flightDTO){

        return flightDTO;
    }
}
