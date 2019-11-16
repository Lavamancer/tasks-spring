package com.example.tasks.config;

import com.example.tasks.config.exception.BadRequestException;
import com.example.tasks.config.exception.NotFoundException;
import com.example.tasks.domain.Log;
import com.example.tasks.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @Autowired LogService logService;


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> notFoundException(Exception e) {
        logService.create(Log.Type.ERROR, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> badRequestException(Exception e) {
        logService.create(Log.Type.ERROR, e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
