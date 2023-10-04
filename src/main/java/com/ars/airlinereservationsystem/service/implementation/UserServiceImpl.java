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

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServiceI {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    @Autowired
    UserServiceImpl(UserRepository userRepository,ModelMapper modelMapper){
        this.userRepository=userRepository;
        this.modelMapper=modelMapper;
    }
    @Override
    public UserDTO deleteUser(String email, String password) {
        User user = userRepository.findUserByEmailAndPassword(email, password);
        if (user != null) {
            userRepository.delete(user);
            return  modelMapper.map(user, UserDTO.class);
        } else {
            throw  new CustomServiceException(404,"User Not Found");
        }
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User user=userRepository.findUserByEmail(userDTO.getEmail());
        if(user!=null){
            user.setId(user.getId());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setName(userDTO.getName());
            user.setAddress(userDTO.getAddress());
            user.setGender(userDTO.getGender());
            user.setNumber(userDTO.getNumber());
            user.setRole(user.getRole());
            userRepository.save(user);
            return this.modelMapper.map(user,UserDTO.class);
        }
        else {
            throw new CustomServiceException(404,"User Data Not found");
        }
    }

    @Override
    public List<UserDTO> getAllPassengerUsers() {
        List<User> passengerUsers = userRepository.findAll()
                .stream()
                .filter(user -> user.getRole() == Role.PASSENGER)
                .toList();
        List<UserDTO> passengerUserDTOList;
        passengerUserDTOList= passengerUsers.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
        return passengerUserDTOList;
    }

    @Override
    public List<UserDTO> getAllAdminUsers() {
        List<User> adminUsers = userRepository.findAll()
                .stream()
                .filter(user -> user.getRole() == Role.ADMIN)
                .toList();
        List<UserDTO> adminUserDTOList;
        adminUserDTOList= adminUsers.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
        return adminUserDTOList;

    }

    @Override
    public UserDTO getUser(String email) {
        User user=userRepository.findUserByEmail(email);
        if (user!=null){
            return this.modelMapper.map(user, UserDTO.class);
        }
        else {
            throw new CustomServiceException(404,"User Not Found");
        }
    }
}
