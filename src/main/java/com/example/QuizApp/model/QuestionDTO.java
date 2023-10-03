package com.example.QuizApp.model;

import com.example.QuizApp.model.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionDTO {
    @NotBlank(message = "category is mandatory")
    @Size(min=2, max=30)
    private String category;
    @NotBlank(message = "QuestionTitle is mandatory")
    private String questionTitle;
    @NotBlank(message = "option1 is mandatory")
    private String option1;
    @NotBlank(message = "option2 is mandatory")
    private String option2;
    @NotBlank(message = "option3 is mandatory")
    private String option3;
    @NotBlank(message = "option4 is mandatory")
    private String option4;
    @NotBlank(message = "rightAnswer is mandatory")
    private String rightAnswer;
    @NotBlank(message = "DifficultyLevel is mandatory")
    @Size(min=2, max=30)
    private String difficultyLevel;



}
