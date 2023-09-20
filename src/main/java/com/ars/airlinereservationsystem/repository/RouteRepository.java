package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}
