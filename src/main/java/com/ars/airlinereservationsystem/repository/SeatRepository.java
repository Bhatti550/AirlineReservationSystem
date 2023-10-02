package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.model.Seat;
import com.ars.airlinereservationsystem.model.util.TravelClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    Seat findBySeatNo(int seatNo);
    List<Seat> findByAirPlane_AirPlaneNo(String airPlaneNo);
    List<Seat> findByPriceStartsWithAndPriceEndingWith(double startPrice, double endPrice);
    List<Seat> findByTravelClass(TravelClass travelClass);
    List<Seat> findByAvailableStatus(boolean availableStatus);

}
