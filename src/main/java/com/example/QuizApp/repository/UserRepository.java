package com.example.QuizApp.repository;

import com.example.QuizApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByEmail(String email);
    Optional<User> findUserByUserName(String userName);

}
