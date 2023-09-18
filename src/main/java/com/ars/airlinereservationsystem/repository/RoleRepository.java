package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleById(Long roleId);
    Role findRoleByRoleName(String roleName);
    void deleteRoleByRoleName(String roleName);
}
