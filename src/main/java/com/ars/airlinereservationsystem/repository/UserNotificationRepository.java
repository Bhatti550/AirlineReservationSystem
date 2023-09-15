package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.model.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserNotificationRepository extends JpaRepository<UserNotification, UUID> {
}
