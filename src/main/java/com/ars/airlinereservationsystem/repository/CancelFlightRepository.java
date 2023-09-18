package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.model.CancelFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancelFlightRepository extends JpaRepository<CancelFlight, Long> {
}
