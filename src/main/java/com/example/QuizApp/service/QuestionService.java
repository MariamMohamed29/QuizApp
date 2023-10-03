package com.example.QuizApp.service;

import com.example.QuizApp.Mapper;
import com.example.QuizApp.error.ApiRequestException;
import com.example.QuizApp.error.DuplicationRecordException;
import com.example.QuizApp.error.RecordNotFoundException;
import com.example.QuizApp.model.QuestionDTO;
import com.example.QuizApp.model.Question;
import com.example.QuizApp.repository.QuestionRepository;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

@NoArgsConstructor
@Builder
public class QuestionService {
    @Autowired
    public QuestionService(QuestionRepository questionRepository, Mapper mapper) {
        this.questionRepository = questionRepository;
        this.mapper = mapper;
    }
    private QuestionRepository questionRepository;
    private Mapper mapper;
    public QuestionDTO addQuestion(@Valid QuestionDTO questionDTO){
        Question storedQuestion=this.questionRepository.findByQuestionTitle(questionDTO.getQuestionTitle());
        if(storedQuestion!=null)
            throw new DuplicationRecordException("Oops! this Question is already in your database");
        Question savedData=mapper.convertDTOQuestionModelToQuestion(questionDTO);
        Question savedquestion=this.questionRepository.save(savedData);
        return mapper.convertQuestionModelToQuestionDto(savedquestion);
    }

    public void deleteQuestionByID(Integer id){
        getQuestionByID(id);
        this.questionRepository.deleteById(id);
    }
    public QuestionDTO updateQuestion(@Valid QuestionDTO questionDTO,int id){
        Optional<Question> question=this.questionRepository.findById(id);
        if(question.isPresent()){
            Question question1= mapper.updateQuestionFromQuestionDto(questionDTO,question.get());
            this.questionRepository.save(question1);
            return mapper.convertQuestionModelToQuestionDto(question1);
        }else {
            throw new RecordNotFoundException("Question not found with id = "+id);
        }
    }
    public List<QuestionDTO> getAllQuestions(){
        return this.questionRepository.findAll().stream()
                .map(question -> mapper.convertQuestionModelToQuestionDto(question))
                .collect(Collectors.toList());
    }
    public List<QuestionDTO> getQuestionsByCategory(String category){
        List<QuestionDTO> questions=this.questionRepository.findByCategoryIgnoreCase(category).stream()
                .map(question -> mapper.convertQuestionModelToQuestionDto(question))
                .collect(Collectors.toList());;
        if(questions.isEmpty()){
            throw new ApiRequestException("No question match this category" + category);
        }
        return questions;
    }
    public QuestionDTO getQuestionByID(int id){
        Question question=this.questionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Question not found with id = "+id));
        return mapper.convertQuestionModelToQuestionDto(question);
    }
    public List<QuestionDTO> getQuestionsByCategoryAndDifficultlyLevel(String category,String difficultyLevel){

        List<QuestionDTO> questions= this.questionRepository.findByCategoryAndDifficultyLevelOrderByCategoryAsc(category,difficultyLevel)
                .stream()
                .map(question -> mapper.convertQuestionModelToQuestionDto(question))
                .collect(Collectors.toList());
        if(questions.isEmpty()){
            throw new ApiRequestException("No question match this category " + category +" and this difficultyLevel "+difficultyLevel);
        }
        return questions;
    }
}
