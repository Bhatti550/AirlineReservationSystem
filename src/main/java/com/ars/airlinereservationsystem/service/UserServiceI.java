package com.ars.airlinereservationsystem.service;

import com.ars.airlinereservationsystem.dto.UserDTO;

import java.util.List;

public interface UserServiceI {
    UserDTO signup(UserDTO userDTO);
    UserDTO deleteUser(String email, String password);
    UserDTO updateUser(UserDTO userDTO, String email);
    List<UserDTO> getAllUsers();
}
