package com.ars.airlinereservationsystem.service.implementation;

import com.ars.airlinereservationsystem.dto.UserDTO;
import com.ars.airlinereservationsystem.exception.CustomServiceException;
import com.ars.airlinereservationsystem.model.User;
import com.ars.airlinereservationsystem.repository.UserRepository;
import com.ars.airlinereservationsystem.service.UserServiceI;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserServiceI {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> createUser(UserDTO userDTO) {
        return  null;
    }

    @Override
    public List<UserDTO> getUser(String email) {
        return null;
    }

    @Override
    public UserDTO deleteUser(String email) {
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public List<UserDTO>getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            UserDTO userDTO = new UserDTO(new ModelMapper()).modelToDto(user);
            userDTOList.add(userDTO);
        }
        if(userDTOList.isEmpty()){
            throw  new CustomServiceException(404,"Data not Found.");
        }
        return userDTOList;
    }
}
