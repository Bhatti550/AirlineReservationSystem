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
        if(userDTO.getName().isEmpty()||userDTO.getEmail().isEmpty()
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
    public List<UserDTO> getAllUsers() {
        List<User> adminUsers = userRepository.findAll()
                .stream()
                .filter(user -> user.getRole() == Role.PASSENGER)
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
