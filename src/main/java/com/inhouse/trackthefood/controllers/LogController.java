package com.inhouse.trackthefood.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inhouse.trackthefood.entities.Log;
import com.inhouse.trackthefood.exceptions.ItemNotFoundException;
import com.inhouse.trackthefood.exceptions.LogNotFoundException;
import com.inhouse.trackthefood.exceptions.UserNotFoundException;
import com.inhouse.trackthefood.services.Impl.LogServiceImpl;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(path = "/log")
public class LogController {

    @Autowired
    LogServiceImpl logServiceImpl;

    @GetMapping("/{id}")
    public Log getMethodName(@PathVariable long id) {
        return logServiceImpl.getLog(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class, UserNotFoundException.class, ItemNotFoundException.class, LogNotFoundException.class})
    public Map<String, String> handleValidationExceptions(
    MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    
}
