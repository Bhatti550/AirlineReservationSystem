package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.model.Booking;
import com.ars.airlinereservationsystem.model.util.TravelClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findBookingById(Long id);
    List<Booking>  findBookingByFlight_FlightCode(String flightCode);
    List<Booking> findBookingByUserId(Long id);
    List<Booking> findBookingByLocalDateTime(LocalDateTime dateTime);
    List<Booking> findBookingByUserIdAndLocalDateTime(Long id, LocalDateTime dateTime);
    List<Booking> findBookingByScheduleId(Long id);
    List<Booking> findBookingBySeatId(Long id);
    List<Booking> findBookingBySeatTravelClass(TravelClass travelClass);
    Booking findBookingByFlight_FlightCodeAndUserIdAndScheduleIdAndSeatIdAndLocalDateTime(
            String flightCode,Long userId, Long scheduleId, Long seatId,
            LocalDateTime dateTime
    );

}
