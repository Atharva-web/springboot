package com.atharva.SecurityApp.dto;

import lombok.Data;

@Data
public class SignupDto {
    private Long id;
    private String email;
    private String password;
    private String name;
}
