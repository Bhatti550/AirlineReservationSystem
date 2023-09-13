package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.entity.CancelFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CancelFlightRepository extends JpaRepository<CancelFlight, UUID> {
}
