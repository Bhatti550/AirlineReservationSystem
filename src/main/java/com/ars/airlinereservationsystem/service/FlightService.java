package com.ars.airlinereservationsystem.service;
import com.ars.airlinereservationsystem.dto.FlightDTO;
import com.ars.airlinereservationsystem.exception.CustomServiceException;
import com.ars.airlinereservationsystem.model.Flight;
import com.ars.airlinereservationsystem.model.Route;
import com.ars.airlinereservationsystem.repository.BookingRepository;
import com.ars.airlinereservationsystem.repository.FlightRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    private final BookingRepository bookingRepository;
    private final ModelMapper modelMapper;

    @Autowired
    FlightService(FlightRepository flightRepository,BookingRepository bookingRepository,ModelMapper modelMapper){
        this.flightRepository=flightRepository;
        this.bookingRepository=bookingRepository;
        this.modelMapper=modelMapper;
    }
    public FlightDTO addFlight(FlightDTO flightDTO){
        Flight flight=flightRepository.findFlightByFlightCode(flightDTO.getFlightCode());
        if (flight!=null){
            throw  new CustomServiceException(403,"Flight already exist");
        }else {
            flight=this.modelMapper.map(flightDTO, Flight.class);
            flightRepository.save(flight);
            FlightDTO flightDTO1=this.modelMapper.map(flight, FlightDTO.class);
            return flightDTO1;
        }
    }
    public FlightDTO updateFlight(FlightDTO flightDTO){
        Flight flight=flightRepository.findFlightByFlightCode(flightDTO.getFlightCode());
        if (flight!=null){
            flight=this.modelMapper.map(flightDTO, Flight.class);
            flight.setId(flight.getId());
            flight.setFlightCode(flightDTO.getFlightCode());
            flight.setFlightStatus(flightDTO.getFlightStatus());
            flight.setRoute(flightDTO.getRoute());
            flightRepository.save(flight);
            FlightDTO flightDTO1=this.modelMapper.map(flight, FlightDTO.class);
            return flightDTO1;

        }else {
            throw  new CustomServiceException(404,"Flight not found");
        }
    }
    public FlightDTO deleteFlight(String flightCode){
        Flight flight=flightRepository.findFlightByFlightCode(flightCode);
        if (flight!=null){
            flightRepository.delete(flight);
            throw  new CustomServiceException(200,"Flight delete Successfully");
        }else {
            throw new CustomServiceException(404,"Flight not found you want to delete");
        }
    }
    public List<FlightDTO> getFlightByRoute(Route route){
        List<Flight> flightsList=flightRepository.findFlightByRoute(route);
        if (flightsList.isEmpty()){
            throw  new CustomServiceException(404,"No Flights Found on this route");
        }else {
            List<FlightDTO> flightDTOList=flightsList.stream()
                    .map(flight -> modelMapper.map(flightsList, FlightDTO.class))
                    .toList();
            return flightDTOList;
        }
    }
    public FlightDTO getFlight(Long id){
        Flight flight=flightRepository.findFlightById(id);
        if (flight!=null){
            FlightDTO flightDTO=this.modelMapper.map(flight, FlightDTO.class);
            return flightDTO;
        }else {
            throw new CustomServiceException(404,"Flight not found");
        }
    }
}
