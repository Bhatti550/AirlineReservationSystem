package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {
}
