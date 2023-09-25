package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    Seat findBySeatNo(int seatNo);
}
