package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.model.AirPlane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirPlaneRepository extends JpaRepository<AirPlane, Long> {
}
