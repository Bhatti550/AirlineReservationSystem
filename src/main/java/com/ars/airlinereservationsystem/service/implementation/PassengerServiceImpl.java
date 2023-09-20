package com.ars.airlinereservationsystem.service.implementation;

import com.ars.airlinereservationsystem.dto.UserDTO;
import com.ars.airlinereservationsystem.model.User;
import com.ars.airlinereservationsystem.repository.UserRepository;
import com.ars.airlinereservationsystem.service.UserServiceI;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PassengerServiceImpl implements UserServiceI {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    @Autowired
    PassengerServiceImpl(UserRepository userRepository,ModelMapper modelMapper){
        this.userRepository=userRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public UserDTO signup(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO deleteUser(String email, String password) {
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, String email) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }
}
