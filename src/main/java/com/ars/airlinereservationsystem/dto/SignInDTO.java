package com.ars.airlinereservationsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignInDTO {
    @Size(min = 6,message = "Password must be at least 6 characters long")
    private String password;
    @Email(message = "Please Provide Valid Email Address")
    private String email;
}
