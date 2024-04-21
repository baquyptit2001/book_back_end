package com.example.backend.Security.jwt;

import lombok.Data;

@Data
public class JWTAuthenticationRequest {
    private String username;
    private String password;
}
