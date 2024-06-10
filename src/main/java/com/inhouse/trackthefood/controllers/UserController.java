package com.inhouse.trackthefood.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.inhouse.trackthefood.Exceptions.ItemNotFoundException;
import com.inhouse.trackthefood.Exceptions.LogNotFoundException;
import com.inhouse.trackthefood.Exceptions.UserNotFoundException;
import com.inhouse.trackthefood.entities.Log;
import com.inhouse.trackthefood.entities.User;
import com.inhouse.trackthefood.services.Impl.LogServiceImpl;
import com.inhouse.trackthefood.services.Impl.UserServiceImpl;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;




@RestController()
@RequestMapping("/user")
public class UserController {

        @Autowired
        UserServiceImpl userServiceImpl;

        @Autowired
        LogServiceImpl logServiceImpl;


        @GetMapping("/{id}")
        public User getMethodName(@PathVariable long id) {
            return userServiceImpl.getUser(id);
        }

        @PostMapping("/join")
        public User postMethodName(@Valid @RequestBody User user) {
            return userServiceImpl.addUser(user);
        }

        @PostMapping("/log")
        public Log postMethodName(@Valid @RequestBody Log log) {
            /* Accepts a log object, Returns the same
             * 1. Fetch user from this log
             * 2. Add this log id to the user
             * 3. Save user data
             * 4. Save log.
             */
            log = logServiceImpl.addLog(log);
            User user = userServiceImpl.getUser(log.getUserid());
            user.newLog(log.getId());
            userServiceImpl.addUser(user);
            return log;
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
