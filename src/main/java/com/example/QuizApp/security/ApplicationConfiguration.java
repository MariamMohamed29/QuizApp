package com.example.QuizApp.security;

import com.example.QuizApp.error.RecordNotFoundException;
import com.example.QuizApp.model.AppUser;
import com.example.QuizApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {
    private final UserRepository userRepository;

    @Bean(name = "studentsDetailsService")
    public UserDetailsService studentsDetailsService(){
        return email -> userRepository.findByEmail(email)
                .orElseThrow(() -> new RecordNotFoundException("There is no User with that phone number !!"));
    }
}
