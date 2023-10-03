package com.example.QuizApp.controller;

import com.example.QuizApp.model.QuestionDTO;
import com.example.QuizApp.model.Question;
import com.example.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @PostMapping("/newQuestion")
    public QuestionDTO addQuestion(@RequestBody QuestionDTO questionDTO){
        return this.questionService.addQuestion(questionDTO);
    }
    @DeleteMapping("/api/{id}")
    public void deleteQuestionByID(@PathVariable Integer id){
        this.questionService.deleteQuestionByID(id);
    }
    @GetMapping("/{id}")
    public QuestionDTO getQuestionById(@PathVariable int id){
        return this.questionService.getQuestionByID(id);
    }
    @PutMapping("/{id}")
    public QuestionDTO updateQuestion(@RequestBody QuestionDTO questionDTO,@PathVariable int id){
        return this.questionService.updateQuestion(  questionDTO,id);
    }
    @GetMapping("/allQuestions")
    public List<QuestionDTO> getAllQuestions(){
        return this.questionService.getAllQuestions();
    }
    @GetMapping("/api/{category}")
    public List<QuestionDTO> getQuestionsByCategory(@PathVariable String category){
        return this.questionService.getQuestionsByCategory(category);
    }
    @GetMapping("/api/{category}/{difficultyLevel}")
    public List<QuestionDTO> getQuestionsByCategoryAndDifficultlyLevel(@PathVariable String category,@PathVariable String difficultyLevel){
        return this.questionService.getQuestionsByCategoryAndDifficultlyLevel(category, difficultyLevel);
    }
}
