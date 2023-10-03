package com.example.QuizApp;

import com.example.QuizApp.model.QuestionDTO;
import com.example.QuizApp.model.Question;
import com.example.QuizApp.model.Quiz;
import com.example.QuizApp.model.QuizDTO;

import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public  QuestionDTO convertQuestionModelToQuestionDto(Question question){
        return QuestionDTO.builder()
                .category(question.getCategory())
                .questionTitle(question.getQuestionTitle())
                .option1(question.getOption1())
                .option2(question.getOption2())
                .option3(question.getOption3())
                .option4(question.getOption4())
                .rightAnswer(question.getRightAnswer())
                .difficultyLevel(question.getDifficultyLevel())
                .build();
    }
    public  Question convertDTOQuestionModelToQuestion(QuestionDTO questionDto){
        return Question.builder()
                .category(questionDto.getCategory())
                .questionTitle(questionDto.getQuestionTitle())
                .option1(questionDto.getOption1())
                .option2(questionDto.getOption2())
                .option3(questionDto.getOption3())
                .option4(questionDto.getOption4())
                .rightAnswer(questionDto.getRightAnswer())
                .difficultyLevel(questionDto.getDifficultyLevel())
                .build();
    }
    public  QuestionDTO convertQuestionModelToQuestionDtoWithoutRightAnswer(Question question){
        return QuestionDTO.builder()
                .category(question.getCategory())
                .questionTitle(question.getQuestionTitle())
                .option1(question.getOption1())
                .option2(question.getOption2())
                .option3(question.getOption3())
                .option4(question.getOption4())
               // .rightAnswer(question.getRightAnswer())
                .difficultyLevel(question.getDifficultyLevel())
                .build();
    }

   public QuizDTO convertQuizModelToQuizDto(Quiz quiz){
                  return QuizDTO.builder()
                          .title(quiz.getTitle())
                          .questions(quiz.getQuestions())
                          .build();
   }
    public Quiz convertQuizDtoModelToQuiz(QuizDTO quizDTO){
        return Quiz.builder()
                .title(quizDTO.getTitle())
                .questions(quizDTO.getQuestions())
                .build();
    }
    public Question updateQuestionFromQuestionDto(QuestionDTO questionDTO, Question question) {
        if (questionDTO == null) {
            return question;
        } else {
            if (questionDTO.getCategory() != null) {
                question.setCategory(questionDTO.getCategory());
            }

            if (questionDTO.getQuestionTitle() != null) {
                question.setQuestionTitle(questionDTO.getQuestionTitle());
            }

            if (questionDTO.getDifficultyLevel() != null) {
                question.setDifficultyLevel(questionDTO.getDifficultyLevel());
            }
            if (questionDTO.getRightAnswer() != null) {
                question.setRightAnswer(questionDTO.getRightAnswer());
            }
            if (questionDTO.getOption1() != null) {
                question.setOption1(questionDTO.getOption1());
            }
            if (questionDTO.getOption2() != null) {
                question.setOption2(questionDTO.getOption2());
            }
            if (questionDTO.getOption3() != null) {
                question.setOption3(questionDTO.getOption3());
            }
            if (questionDTO.getOption4()!= null) {
                question.setOption4(questionDTO.getOption4());
            }return question;

        }
    }
}