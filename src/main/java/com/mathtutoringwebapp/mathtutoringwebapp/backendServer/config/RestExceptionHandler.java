package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.config;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.otherDtos.ErrorDto;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.exception.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = { AppException.class })
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(AppException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(ErrorDto.builder().message(ex.getMessage()).build());
    }
}
