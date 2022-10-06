package com.example.groject.global.error;

import com.example.groject.global.error.exception.ErrorCode;
import com.example.groject.global.error.exception.GrowException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GrowException.class)
    public ResponseEntity<ErrorResponse> exceptionValid(GrowException e) {
        ErrorCode errorCode = e.getErrorCode();

        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .status(errorCode.getStatus())
                        .message(errorCode.getMessage())
                        .build(), HttpStatus.valueOf(errorCode.getStatus())
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> exceptionValidFunc(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(
                new ErrorResponse(400, e.getBindingResult().getAllErrors().get(0).getDefaultMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
}
