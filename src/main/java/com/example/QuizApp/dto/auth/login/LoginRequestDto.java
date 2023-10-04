package com.example.QuizApp.dto.auth.login;

import com.example.QuizApp.dto.auth.register.RegisterRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto extends RegisterRequestDto {
    private String confirmPassword;
}
