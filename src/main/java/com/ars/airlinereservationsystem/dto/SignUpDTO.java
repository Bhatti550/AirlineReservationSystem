package com.ars.airlinereservationsystem.dto;

import com.ars.airlinereservationsystem.model.util.Gender;
import com.ars.airlinereservationsystem.model.util.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDTO {
    @NotNull
    private String name;
    @Size(min = 6,message = "Password must be at least 6 characters long")
    private String password;
    @Email(message = "Please Provide Valid Email Address")
    private String email;
    @Size(max =13, min = 13,message = "Number no less then 13 digit, Country code is Included")
    private Long number;
    private Gender gender;
    private Role role;
    @Size(max = 200, min = 3)
    private String address;
}
