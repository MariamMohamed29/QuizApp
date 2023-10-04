package com.example.QuizApp.dto.auth.login;

import com.example.QuizApp.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponseDto {
    private String userName;
    private String email;
    private Role role;
    private boolean isAuthenticated;
    private String token;
}
