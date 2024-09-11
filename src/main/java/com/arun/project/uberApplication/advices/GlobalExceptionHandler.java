package com.arun.project.uberApplication.advices;

import com.arun.project.uberApplication.exceptions.ResourceNotFoundException;
import com.arun.project.uberApplication.exceptions.RuntimeConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> resourceNotFoundHandler(ResourceNotFoundException e){
        ApiError apiError=ApiError.builder()
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();
        return helperHandler(apiError);
    }

    @ExceptionHandler(RuntimeConflictException.class)
    public ResponseEntity<ApiResponse<?>> handleRuntimeConflictException(RuntimeConflictException e){
        ApiError apiError=ApiError.builder()
                .message(e.getMessage())
                .status(HttpStatus.CONFLICT)
                .build();
        return helperHandler(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleInternalServerError(Exception e){

        ApiError apiError=ApiError.builder()
                .message(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return helperHandler(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleInputValidationErrors(MethodArgumentNotValidException e){

        List<String> errors = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        ApiError invalidInputErrors = ApiError.builder()
                .message("Invalid Input Errors")
                .subErrors(errors)
                .status(HttpStatus.BAD_REQUEST)
                .build();

        return helperHandler(invalidInputErrors);
    }


    private ResponseEntity<ApiResponse<?>> helperHandler(ApiError apiError) {
       ApiResponse apiResponse=ApiResponse.builder()
                .error(apiError)
                .build();
       return new ResponseEntity<>(apiResponse,apiError.getStatus());
    }


}
