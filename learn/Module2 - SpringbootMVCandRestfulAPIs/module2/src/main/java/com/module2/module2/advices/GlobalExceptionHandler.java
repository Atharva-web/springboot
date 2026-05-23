package com.module2.module2.advices;

import com.module2.module2.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFound(ResourceNotFoundException exception) {
        ApiError apiError = ApiError.builder()
                .statusCode(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();

        ApiResponse apiResponse = ApiResponse.builder()
                .error(apiError)
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        List<String> errors = exception
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .toList();


        ApiError apiError = ApiError.builder()
                .subErrors(errors)
                .message("Error while validating method arguments")
                .statusCode(HttpStatus.BAD_REQUEST)
                .build();

        ApiResponse apiResponse = ApiResponse.builder()
                .error(apiError)
                .timeStamp(LocalDateTime.now())
                .build();

        return ResponseEntity.badRequest().body(apiResponse);
    }
}
