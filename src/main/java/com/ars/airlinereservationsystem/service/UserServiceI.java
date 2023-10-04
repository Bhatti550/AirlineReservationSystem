package com.ars.airlinereservationsystem.service;

import com.ars.airlinereservationsystem.dto.UserDTO;

import java.util.List;

public interface UserServiceI {
    UserDTO deleteUser(String email, String password);
    UserDTO updateUser(UserDTO userDTO);
    List<UserDTO> getAllPassengerUsers();
    UserDTO getUser(String email);
    List<UserDTO> getAllAdminUsers();
}
