package com.ars.airlinereservationsystem.service;

import com.ars.airlinereservationsystem.dto.UserDTO;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface UserServiceI {
     List<UserDTO> createUser(UserDTO userDTO);
     List<UserDTO> getUser(String email);
     UserDTO deleteUser( String email);
     UserDTO updateUser(UserDTO userDTO);
     List<UserDTO> getAllUsers();

}
