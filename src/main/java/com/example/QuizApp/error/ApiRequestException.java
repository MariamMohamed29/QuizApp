package com.example.QuizApp.error;

public class ApiRequestException extends RuntimeException{
    public ApiRequestException() {
        super();
    }

    public ApiRequestException(String message) {
        super(message);
    }
}
