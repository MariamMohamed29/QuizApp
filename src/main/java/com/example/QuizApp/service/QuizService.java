package com.example.QuizApp.service;

import com.example.QuizApp.Mapper;
import com.example.QuizApp.error.ApiRequestException;
import com.example.QuizApp.error.RecordNotFoundException;
import com.example.QuizApp.model.Question;
import com.example.QuizApp.model.QuestionDTO;
import com.example.QuizApp.model.Quiz;
import com.example.QuizApp.repository.QuestionRepository;
import com.example.QuizApp.repository.QuizRepository;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

@NoArgsConstructor
@Builder
public class QuizService {
    @Autowired
    public QuizService(QuestionRepository questionRepository,QuizRepository quizRepository, Mapper mapper) {
        this.questionRepository = questionRepository;
        this.quizRepository=quizRepository;
        this.mapper = mapper;
    }
    private QuestionRepository questionRepository;
    private QuizRepository quizRepository;
    private Mapper mapper;
    public String createQuiz(String category,int numOfQues,String title){
        List<Question> questions=questionRepository.findRandomQuestionsByCategory(category,numOfQues);
        if (questions.isEmpty())
            throw new  ApiRequestException("No question match this category "+category);
        Quiz quiz=new Quiz();
        quiz.setQuestions(questions);
        quiz.setTitle(title);
        quizRepository.save(quiz);
        return "success";
    }
    public List<QuestionDTO> getQuizQuestions(int id){
        Optional<Quiz> quiz=quizRepository.findById(id);
        if(quiz.isPresent()){
        List<Question> questions=quiz.get().getQuestions();
        return questions.stream()
                .map(question -> mapper.convertQuestionModelToQuestionDtoWithoutRightAnswer(question))
                .collect(Collectors.toList());}
        else throw new RecordNotFoundException("Quiz not found with id = "+id);
    }

    public int calculateResult(int id,List<String> responses){
        Optional<Quiz> quiz=quizRepository.findById(id);
        if(quiz.isPresent()){
        List<Question> questions=quiz.get().getQuestions();
        int i=0;
        int score=0;
        for(String response: responses){
            if(response .equals(questions.get(i).getRightAnswer()))
                score+=1;
            i+=1;
        }
        return score;}
        else throw new RecordNotFoundException("Quiz not found with id = "+id);
    }
}
