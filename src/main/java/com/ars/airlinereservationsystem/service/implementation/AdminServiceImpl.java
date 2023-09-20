package com.ars.airlinereservationsystem.service.implementation;

import com.ars.airlinereservationsystem.dto.UserDTO;
import com.ars.airlinereservationsystem.exception.CustomServiceException;
import com.ars.airlinereservationsystem.model.User;
import com.ars.airlinereservationsystem.model.util.Role;
import com.ars.airlinereservationsystem.repository.UserRepository;
import com.ars.airlinereservationsystem.service.UserServiceI;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements UserServiceI {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    @Autowired
    AdminServiceImpl(UserRepository userRepository,ModelMapper modelMapper){
        this.userRepository=userRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public UserDTO signup(UserDTO userDTO) {

        if(userDTO.getRole()==null||userDTO.getName().isEmpty()||userDTO.getEmail().isEmpty()
        ||userDTO.getPassword().isEmpty()) {
            throw new CustomServiceException(400,"Some Data is Missing");
        } else if (userDTO.getGender()==null) {
            throw new CustomServiceException(400,"Some Data is Missing");
        }
        User user = this.modelMapper.map(userDTO, User.class);
        User user1 = userRepository.save(user);
        return this.modelMapper.map(user1, UserDTO.class);
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
        List<User> adminUsers = userRepository.findAll()
                .stream()
                .filter(user -> user.getRole() == Role.ADMIN)
                .toList();
        List<UserDTO> adminUserDTOList=new ArrayList<>();
        adminUserDTOList= adminUsers.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
        return adminUserDTOList;

    }
}
