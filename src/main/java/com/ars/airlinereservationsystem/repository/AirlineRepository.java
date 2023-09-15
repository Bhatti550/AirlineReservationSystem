package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AirlineRepository extends JpaRepository<Airline, UUID> {
}
