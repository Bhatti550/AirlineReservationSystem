package com.ars.airlinereservationsystem.dto;

import com.ars.airlinereservationsystem.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class UserDTO {
    private Long id;
    @NotNull
    private String name;
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;
    @Email(message = "Please Provide Valid Email Address")
    private String email;
    @Size(max =13, message = "Number no less then 13 digit, Country code is Included")
    private Long number;
    private Role role;
}
