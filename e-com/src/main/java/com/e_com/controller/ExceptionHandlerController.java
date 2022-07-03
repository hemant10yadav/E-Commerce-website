package com.e_com.controller;

import com.e_com.exception_handler.DataBaseException;
import com.e_com.exception_handler.ExceptionMessage;
import com.e_com.exception_handler.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler
    public ResponseEntity<ExceptionMessage> handleException(UserException exc) {
        ExceptionMessage error = new ExceptionMessage();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionMessage> Exception(DataBaseException exc){
        ExceptionMessage error = new ExceptionMessage();
        error.setStatus(HttpStatus.ALREADY_REPORTED.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_ACCEPTABLE);
    }
}
