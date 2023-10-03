package com.example.QuizApp.controller;

import com.example.QuizApp.model.QuestionDTO;
import com.example.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {
    @Autowired
    private QuizService quizService;
    @PostMapping("/quiz")
    public String createQuiz(@RequestParam String category,@RequestParam int numOfQues,@RequestParam String title){
      return this.quizService.createQuiz(category,numOfQues,title);
    }
    @GetMapping("QuizQuestions/{id}")
    public List<QuestionDTO> getQuizQuestions(@PathVariable int id){
        return this.quizService.getQuizQuestions(id);
    }
    @PostMapping("/submission/{id}")
    public int calculateResult(@PathVariable int id,@RequestBody List<String> responses){
        return this.quizService.calculateResult(id,responses);
    }
}
