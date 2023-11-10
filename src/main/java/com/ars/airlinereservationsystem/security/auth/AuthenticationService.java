package com.ars.airlinereservationsystem.security.auth;

import com.ars.airlinereservationsystem.dto.SignInDTO;
import com.ars.airlinereservationsystem.dto.SignUpDTO;
import com.ars.airlinereservationsystem.exception.CustomServiceException;
import com.ars.airlinereservationsystem.model.User;
import com.ars.airlinereservationsystem.repository.UserRepository;
import com.ars.airlinereservationsystem.security.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    @Autowired
    public AuthenticationService(ModelMapper modelMapper,UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.modelMapper=modelMapper;
    }

    public AuthenticationResponse register(SignUpDTO request) {
        User user=userRepository.findUserByEmail(request.getEmail());
        if(user!=null){
            throw new CustomServiceException(200,"User is already Exist");
        } else if(request.getRole() == null || request.getName().isEmpty() || request.getEmail().isEmpty()
                || request.getPassword().isEmpty()) {
            throw new CustomServiceException(400, "Some Data is Missing");
        } else if (request.getGender() == null) {
            throw new CustomServiceException(400, "Some Data is Missing");
        }
        User user1 = modelMapper.map(request, User.class);
        user1.setPassword(passwordEncoder.encode(request.getPassword()));
        User savedUser = userRepository.save(user1);
        String token = jwtService.generateToken(savedUser);
        SignUpDTO userDTO = modelMapper.map(savedUser, SignUpDTO.class);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }


    public AuthenticationResponse authenticate(SignInDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String token = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(token).build();
    }
}
