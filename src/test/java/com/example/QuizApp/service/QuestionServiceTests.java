package com.example.QuizApp.service;

import com.example.QuizApp.Mapper;
import com.example.QuizApp.model.Question;
import com.example.QuizApp.model.QuestionDTO;
import com.example.QuizApp.repository.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class QuestionServiceTests {
  @InjectMocks
    private QuestionService questionService;
  @Mock
    private QuestionRepository questionRepository;
  @Mock
    private Mapper mapper;

  Question question;
  QuestionDTO questionDTO;
  @BeforeEach
    public void setup(){
      MockitoAnnotations.initMocks(this);
      question=Question.builder().id(1).
              category("java")
              .questionTitle("which java keyword is used to create a subclass?")
              .option1("class")
              .option2("interface")
              .option3("extends")
              .option4("implements")
              .rightAnswer("extends")
              .difficultyLevel("easy").build();
      questionDTO =QuestionDTO.builder().category(question.getCategory())
              .questionTitle(question.getQuestionTitle())
              .option1(question.getOption1())
              .option2(question.getOption2())
              .option3(question.getOption3())
              .option4(question.getOption4())
              .rightAnswer(question.getRightAnswer())
              .difficultyLevel(question.getDifficultyLevel()).build();
  }
  @Test
  public void givenQuestionDto_whenAddQuestion_thenReturnQuestionDto(){
      when(mapper.convertDTOQuestionModelToQuestion(questionDTO)).thenReturn(question);
      when(questionRepository.save(question)).thenReturn(question);
      when(mapper.convertQuestionModelToQuestionDto(question)).thenReturn(questionDTO);

      QuestionDTO returnedQuestion=questionService.addQuestion(questionDTO);

      assertEquals(returnedQuestion,questionDTO);
  }
    @Test
    public void givenQuestionDTOAndQuestionId_whenUpdateQuestion_thenReturnUpdatedQuestionDTO(){
       QuestionDTO updatedQuestionDTO=QuestionDTO.builder()
               . category("java")
                .questionTitle("which java keyword is used to create a subclass?")
                .option1("class")
                .option2("interface")
                .option3("extends")
                .option4("implements")
                .rightAnswer("extends")
                .difficultyLevel("hard").build();
       Question updatedQuestion =Question.builder().id(1).category(updatedQuestionDTO.getCategory())
                .questionTitle(updatedQuestionDTO.getQuestionTitle())
                .option1(updatedQuestionDTO.getOption1())
                .option2(updatedQuestionDTO.getOption2())
                .option3(updatedQuestionDTO.getOption3())
                .option4(updatedQuestionDTO.getOption4())
                .rightAnswer(updatedQuestionDTO.getRightAnswer())
                .difficultyLevel(updatedQuestionDTO.getDifficultyLevel()).build();
       int id=question.getId();
       when(questionRepository.findById(id)).thenReturn(Optional.ofNullable(question));
       when(mapper.updateQuestionFromQuestionDto(updatedQuestionDTO,question)).thenReturn(updatedQuestion);
       when(questionRepository.save(updatedQuestion)).thenReturn(updatedQuestion);
       when(mapper.convertQuestionModelToQuestionDto(updatedQuestion)).thenReturn(updatedQuestionDTO);

       QuestionDTO returnedQuestionDTO=questionService.updateQuestion(updatedQuestionDTO,id);
        assertEquals(returnedQuestionDTO,updatedQuestionDTO);
    }
    @Test
    public void givenQuestionsList_whenGetAllQuestions_thenReturnListOfQuestionDTO(){
      Question question2=Question.builder().id(4).
              category("java")
              .questionTitle("Who invented Java Programming?")
              .option1("Guido van Rossum")
              .option2("James Gosling")
              .option3("Dennis Ritchie")
              .option4("Bjarne Stroustrup")
              .rightAnswer("James Gosling")
              .difficultyLevel("easy").build();

      when(questionRepository.findAll()).thenReturn(List.of(question,question2));
      when(mapper.convertQuestionModelToQuestionDto(question)).thenReturn(questionDTO);

      List<QuestionDTO> questions=questionService.getAllQuestions();

      assertEquals(questions.get(0),questionDTO);
    }
    @Test
    public void givenQuestionCategory_whenGetQuestionsByCategory_thenReturnListOfQuestionDTO(){
        Question question2=Question.builder().id(4).
                category("java")
                .questionTitle("Who invented Java Programming?")
                .option1("Guido van Rossum")
                .option2("James Gosling")
                .option3("Dennis Ritchie")
                .option4("Bjarne Stroustrup")
                .rightAnswer("James Gosling")
                .difficultyLevel("easy").build();
        String category=question.getCategory();

        when(questionRepository.findByCategoryIgnoreCase(category)).thenReturn(List.of(question,question2));
        when(mapper.convertQuestionModelToQuestionDto(question)).thenReturn(questionDTO);

        List<QuestionDTO> questions=questionService.getQuestionsByCategory(category);

        assertEquals(questions.get(0),questionDTO);
    }
    @Test
    public void givenQuestionCategoryAndDifficultyLevel_whenGetQuestionsByCategoryAndDifficultyLevel_thenReturnListOfQuestionDTO(){
        Question question2=Question.builder().id(4).
                category("java")
                .questionTitle("Who invented Java Programming?")
                .option1("Guido van Rossum")
                .option2("James Gosling")
                .option3("Dennis Ritchie")
                .option4("Bjarne Stroustrup")
                .rightAnswer("James Gosling")
                .difficultyLevel("easy").build();
        String category=question.getCategory();
        String difficultyLevel=question.getDifficultyLevel();

        when(questionRepository.findByCategoryAndDifficultyLevelOrderByCategoryAsc(category,difficultyLevel)).thenReturn(List.of(question,question2));
        when(mapper.convertQuestionModelToQuestionDto(question)).thenReturn(questionDTO);

        List<QuestionDTO> questions=questionService.getQuestionsByCategoryAndDifficultlyLevel(category,difficultyLevel);

        assertEquals(questions.get(0),questionDTO);
    }
    @Test
    public void givenQuestionsId_whenGetQuestionById_QuestionDTO(){
      int id=question.getId();
      when(questionRepository.findById(id)).thenReturn(Optional.ofNullable(question));
      when(mapper.convertQuestionModelToQuestionDto(question)).thenReturn(questionDTO);

      QuestionDTO returnedQuestion=questionService.getQuestionByID(id);

      assertEquals(returnedQuestion,questionDTO);

    }

}
