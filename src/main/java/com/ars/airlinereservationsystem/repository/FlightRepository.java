package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.model.Flight;
import com.ars.airlinereservationsystem.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findFlightById(Long id);
    Flight findFlightByFlightCode(String code);
    List<Flight> findFlightByRoute(Route route);
}
