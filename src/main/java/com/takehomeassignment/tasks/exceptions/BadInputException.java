package com.takehomeassignment.tasks.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadInputException extends RuntimeException {
    public BadInputException(String message) {
        super(message);
    }
}
