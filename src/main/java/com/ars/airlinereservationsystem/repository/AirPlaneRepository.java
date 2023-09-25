package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.model.AirPlane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirPlaneRepository extends JpaRepository<AirPlane, Long> {
    AirPlane findByAirPlaneNo(String airPlaneNo);
    List<AirPlane> findAirPlaneByAirlineCompanyId(Long airlineCompanyID);
}
