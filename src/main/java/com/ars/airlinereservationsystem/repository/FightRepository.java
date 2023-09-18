package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FightRepository extends JpaRepository<Flight, Long> {
}
