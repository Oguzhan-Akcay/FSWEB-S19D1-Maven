package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalException {
    @ExceptionHandler
    public ResponseEntity<FruitErrorResponse> handleException(FruitException fruitException){
        FruitErrorResponse fruiteExcept = new FruitErrorResponse(fruitException.getHttpStatus().value(), fruitException.getMessage(), LocalDateTime.now());
        log.error("Exception: ", fruitException);
        return new ResponseEntity<>(fruiteExcept, fruitException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<FruitErrorResponse> handleException(Exception e){
        FruitErrorResponse fruiteException = new FruitErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), LocalDateTime.now());
        log.error("Exception: ", e);
        return new ResponseEntity<>(fruiteException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
