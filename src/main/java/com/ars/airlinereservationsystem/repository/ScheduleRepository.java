package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Schedule findScheduleById(Long id);
    @Query("SELECT s FROM Schedule s WHERE s.departureTime>= :departureTime AND s.arrivalTime <=:arrivalTime")
    List<Schedule> findSchedulesByDepartureTimeAndArrivalTime(@Param("departureTime") LocalDateTime departureTime, @Param("arrivalTime") LocalDateTime arrivalTime);
    List<Schedule> findScheduleByFlight_Id(Long id);
}
