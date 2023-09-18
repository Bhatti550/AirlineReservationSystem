package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.model.User;
import com.ars.airlinereservationsystem.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    User findUserRoleByUser_Email(String email);
}
