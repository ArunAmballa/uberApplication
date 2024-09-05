package com.arun.project.uberApplication.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {

    private String email;

    private String password;

    private String name;
}
