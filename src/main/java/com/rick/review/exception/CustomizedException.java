package com.rick.review.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomizedException extends RuntimeException{
    private HttpStatus httpStatus;
    private String errorMessage;
    private String adviceMessage;

    public CustomizedException(String errorMessage, String adviceMessage, HttpStatus httpStatus){
        this.errorMessage = errorMessage;
        this.adviceMessage = adviceMessage;
        this.httpStatus = httpStatus;
    }
}
