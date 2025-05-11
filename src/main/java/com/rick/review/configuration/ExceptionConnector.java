package com.rick.review.configuration;

import com.rick.review.dto.ErrorDto;
import com.rick.review.exception.CustomizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionConnector {

    @ExceptionHandler
    public ResponseEntity<ErrorDto> handleCustomizeException(final CustomizedException ex){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setAdvice(ex.getAdviceMessage());
        errorDto.setCode(400);
        errorDto.setMessage(ex.getMessage());
        errorDto.setRootCause(ex.toString());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
}
