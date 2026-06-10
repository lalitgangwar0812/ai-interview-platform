package com.lalit.aiinterviewplatform.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lalit.aiinterviewplatform.dto.ErrorResponse;

/*
 * Global Exception Handler
 *
 * Purpose:
 * Catches exceptions thrown anywhere in the application
 * and converts them into clean API responses.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /*
     * Handles RuntimeException.
     *
     * Examples:
     * - Email already registered
     * - Invalid email or password
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(
            RuntimeException exception) {

        ErrorResponse errorResponse =
                new ErrorResponse(exception.getMessage());

        return new ResponseEntity<>(
                errorResponse,
                HttpStatus.BAD_REQUEST);
    }
}