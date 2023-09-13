package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
}
