package com.example.QuizApp.repository;

import com.example.QuizApp.model.Question;
import com.example.QuizApp.model.QuestionDTO;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest

public class QuestionRepositoryTests {
    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void questionRepository_findByQuestionTitle_returnQuestion(){
        Question givenQuestion=questionRepository.findByQuestionTitle("which java keyword is used to create a subclass?");
        assertEquals("which java keyword is used to create a subclass?",givenQuestion.getQuestionTitle());

    }
    @Test
    public void questionRepository_findByCategory_returnQuestions(){
        List<Question> questions=questionRepository.findByCategoryIgnoreCase("java");
        Question question=Question.builder().id(1).
         category("java")
                .questionTitle("which java keyword is used to create a subclass?")
                .option1("class")
                .option2("interface")
                .option3("extends")
                .option4("implements")
                .rightAnswer("extends")
                .difficultyLevel("easy").build();
        assertEquals(question,questions.get(0));

    }
    @Test
    public void questionRepository_findByCategoryAndDifficultyLevel_returnQuestions(){
        List<Question> questions=questionRepository.findByCategoryAndDifficultyLevelOrderByCategoryAsc("java","easy");
        Question question=Question.builder().id(1).
                category("java")
                .questionTitle("which java keyword is used to create a subclass?")
                .option1("class")
                .option2("interface")
                .option3("extends")
                .option4("implements")
                .rightAnswer("extends")
                .difficultyLevel("easy").build();
        assertEquals(question,questions.get(0));
    }
    @Test
    public void questionRepository_findRandomByCategory_returnQuestions(){
        List<Question> questions=questionRepository.findRandomQuestionsByCategory("java",5);
        Assertions.assertThat(questions.size()).isGreaterThan(0);
    }

}
