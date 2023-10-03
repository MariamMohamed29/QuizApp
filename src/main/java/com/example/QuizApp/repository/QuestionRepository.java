package com.example.QuizApp.repository;

import com.example.QuizApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
    Question findByQuestionTitle(String questionTitle);
List<Question> findByCategoryIgnoreCase(String category);
List<Question> findByCategoryAndDifficultyLevelOrderByCategoryAsc(String category,String difficultyLevel);
@Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :nomOfQues",nativeQuery = true)
List<Question> findRandomQuestionsByCategory(String category,int nomOfQues);
}
