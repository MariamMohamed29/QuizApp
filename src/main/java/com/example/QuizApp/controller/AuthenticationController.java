package com.example.QuizApp.controller;


import com.example.QuizApp.dto.auth.login.LoginRequestDto;
import com.example.QuizApp.dto.auth.login.LoginResponseDto;
import com.example.QuizApp.dto.auth.register.RegisterRequestDto;
import com.example.QuizApp.dto.auth.register.RegisterResponseDto;
import com.example.QuizApp.error.RecordNotFoundException;
import com.example.QuizApp.service.JwtAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
@RequiredArgsConstructor
public class AuthenticationController {

    private final JwtAuthenticationService authService;

    @PostMapping("register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto dto){
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto dto) throws RecordNotFoundException{
        return ResponseEntity.ok(authService.login(dto));
    }
}
