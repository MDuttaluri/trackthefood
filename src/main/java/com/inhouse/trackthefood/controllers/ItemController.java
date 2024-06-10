package com.inhouse.trackthefood.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inhouse.trackthefood.entities.Item;
import com.inhouse.trackthefood.exceptions.ItemNotFoundException;
import com.inhouse.trackthefood.exceptions.LogNotFoundException;
import com.inhouse.trackthefood.exceptions.UserNotFoundException;
import com.inhouse.trackthefood.services.Impl.ItemServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    ItemServiceImpl itemServiceImpl;

    @GetMapping("/{id}")
    public Item getMethodName(@PathVariable long id) {
        Item item = itemServiceImpl.getItem(id);
        return item;
    }

    @PostMapping("/add")
    public Item postMethodName(@Valid @RequestBody Item item) {
        return itemServiceImpl.addItem(item);
    }

    @GetMapping("/nameLike/{name}")
    public List<Item> getMethodName(@PathVariable String name) {
        return itemServiceImpl.getItemByName(name);
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
