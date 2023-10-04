package com.example.QuizApp.service;

import com.example.QuizApp.dto.auth.login.LoginRequestDto;
import com.example.QuizApp.dto.auth.login.LoginResponseDto;
import com.example.QuizApp.dto.auth.register.RegisterRequestDto;
import com.example.QuizApp.dto.auth.register.RegisterResponseDto;
import com.example.QuizApp.error.RecordNotFoundException;
import com.example.QuizApp.model.Role;
import com.example.QuizApp.model.User;
import com.example.QuizApp.repository.UserRepository;
import com.example.QuizApp.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class JwtAuthenticationService  {

    private final UserRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public RegisterResponseDto register(RegisterRequestDto dto) throws RecordNotFoundException {
        var user = User
                .builder()
                .userName(dto.getUserNameOrEmail())
                .email(dto.getUserNameOrEmail())
                .role(Role.ROLE_USER)
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();

        try {
            User savedUser = repository.save(user);
            return RegisterResponseDto
                    .builder()
                    .email(savedUser.getEmail())
                    .userName(savedUser.getUsername())
                    .role(savedUser.getRole())
                    .build();
        } catch (Exception e) {
            System.out.println("Caught Exception");
            throw new RecordNotFoundException("There is already user with that user name");
        }
    }

    public LoginResponseDto login(LoginRequestDto dto) throws  RecordNotFoundException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            dto.getUserNameOrEmail(),
                            dto.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            throw new RecordNotFoundException("There is no authenticated user with that credentials");
        }

        var user = repository.findUserByUserName(dto.getUserNameOrEmail())
                .orElseThrow(() -> new RecordNotFoundException("There is no user with that email."));
        Map<String, Object> claims = Map.of("userId", user.getId(), "email", user.getEmail());
        var token = jwtService.generateToken(claims, user);
        return LoginResponseDto.builder()
                .isAuthenticated(true)
                .userName(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .token(token)
                .build();
    }
}
