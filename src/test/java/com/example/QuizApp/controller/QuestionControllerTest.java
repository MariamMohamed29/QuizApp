package com.example.QuizApp.controller;

import com.example.QuizApp.Mapper;
import com.example.QuizApp.model.QuestionDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class QuestionControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    private Mapper mapper;
    @Test
    public void givenQuestionDto_whenAddQuestion_thenReturnQuestionDto() throws Exception{
        String url="/newQuestion";
        QuestionDTO response=QuestionDTO.builder()
                . category("java")
                .questionTitle("which java keyword is used to create a subclass?")
                .option1("class")
                .option2("interface")
                .option3("extends")
                .option4("implements")
                .rightAnswer("extends")
                .difficultyLevel("hard").build();
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .content(String.valueOf(response))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect((ResultMatcher) response);
    }
}
