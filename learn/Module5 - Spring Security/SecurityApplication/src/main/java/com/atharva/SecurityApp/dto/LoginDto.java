package com.atharva.SecurityApp.dto;

import lombok.Data;

@Data
public class LoginDto {
    private Long id;
    private String email;
    private String password;
    private String name;
}
