package com.inhouse.trackthefood.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inhouse.trackthefood.entities.Log;
import com.inhouse.trackthefood.services.Impl.LogServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(path = "/log")
public class LogController {

    @Autowired
    LogServiceImpl logServiceImpl;

    @GetMapping("/{id}")
    public Log getMethodName(@PathVariable long id) {
        return logServiceImpl.getLog(id);
    }

    @PostMapping("/update/{id}")
    public Log updateLog(@Valid @RequestBody Log log, @PathVariable long id) {
        log.setId(id);
        return logServiceImpl.addLog(log);
    }
    

    @PostMapping("/add")
    public Log addLog(@RequestBody Log log) {
        System.out.println(log.toString());
        
        return logServiceImpl.addLog(log);
        // return log;
        
    }
    

    
    
}
