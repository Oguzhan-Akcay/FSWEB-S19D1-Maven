package com.workintech.s18d2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class FruitErrorResponse {
    private int httpStatus;
    private String message;
    private LocalDateTime date;
}
