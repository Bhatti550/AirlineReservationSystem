package com.ars.airlinereservationsystem.service.implementation;

import com.ars.airlinereservationsystem.dto.UserDTO;
import com.ars.airlinereservationsystem.exception.CustomServiceException;
import com.ars.airlinereservationsystem.model.Role;
import com.ars.airlinereservationsystem.model.User;
import com.ars.airlinereservationsystem.model.UserRole;
import com.ars.airlinereservationsystem.repository.RoleRepository;
import com.ars.airlinereservationsystem.repository.UserRepository;
import com.ars.airlinereservationsystem.repository.UserRoleRepository;
import com.ars.airlinereservationsystem.service.UserServiceI;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserServiceI {

    private final UserRepository userRepository;
    private  final ModelMapper modelMapper;
    private  final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,RoleRepository roleRepository,
                           ModelMapper modelMapper,UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.modelMapper=modelMapper;
        this.userRoleRepository=userRoleRepository;
        this.roleRepository=roleRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        String dtoEmail = userDTO.getEmail();
        User userExist = userRepository.findUserByEmail(dtoEmail);
        if (userExist != null) {
            throw new CustomServiceException(409, "User already exists with the same Mobile Number!");
        } else {
            User user = modelMapper.map(userDTO, User.class);
            Role role = roleRepository.findRoleById(userDTO.getRole().getId());
            if (role == null) {
                throw new CustomServiceException(404, "Role not found with the provided ID");
            }
            userRepository.save(user);
            UserRole userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(role);
            userRoleRepository.save(userRole);
            UserDTO userDTO1 = modelMapper.map(user, UserDTO.class);
            return userDTO1;
        }
    }

    @Override
    public List<UserDTO> getUser(String email) {
        User user = userRepository.findUserByEmail(email);
        UserDTO userDTO = this.modelMapper.map(user, UserDTO.class);
        List<UserDTO> userDTOList = new ArrayList<>();
        userDTOList.add(userDTO);
        if (userDTOList!=null) {
            return userDTOList;
        } else {
            throw new CustomServiceException(404, "User Not Found Against this Email");

        }
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
            UserDTO userDTO = this.modelMapper.map(user, UserDTO.class);
            userDTOList.add(userDTO);
        }
        if(userDTOList.isEmpty()){
            throw  new CustomServiceException(404,"Data not Found.");
        }
        return userDTOList;
    }
}
