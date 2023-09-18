package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.model.BookTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookTicket, Long> {
}
