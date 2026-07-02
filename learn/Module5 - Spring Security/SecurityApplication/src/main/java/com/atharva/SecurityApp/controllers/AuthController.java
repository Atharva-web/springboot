package com.atharva.SecurityApp.controllers;

import com.atharva.SecurityApp.dto.LoginDto;
import com.atharva.SecurityApp.dto.SignupDto;
import com.atharva.SecurityApp.dto.UserDto;
import com.atharva.SecurityApp.services.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody SignupDto signupDto) {
        return ResponseEntity.ok(authService.signup(signupDto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        System.out.println("Entering login...");

        Cookie cookie = new Cookie("jwt-cookie", authService.login(loginDto));
        cookie.setHttpOnly(true);
        httpServletResponse.addCookie(cookie);
        return ResponseEntity.ok("👌🏼");
    }
}
