package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findRouteByAirlineCompany_Name(String name);
    Route findRoutesById(Long id);
    List<Route> findRouteByDepartureLocationAndDestinationLocation(String departureLocation, String destinationLocation);
}
