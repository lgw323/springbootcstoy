package com.iamjesus.homework.global.exception;

import com.iamjesus.homework.global.exception.domain.UnauthorizedException;
import com.iamjesus.homework.global.exception.dto.ExceptionCode;
import com.iamjesus.homework.global.exception.dto.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ExceptionResponse> handleException(final UnauthorizedException e){
        ExceptionCode exception = e.getCode();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ExceptionResponse(exception.getCode(), exception.getMessage()) );
    }
}
