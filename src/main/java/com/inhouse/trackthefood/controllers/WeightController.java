package com.inhouse.trackthefood.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inhouse.trackthefood.entities.Weight;
import com.inhouse.trackthefood.services.Impl.UserServiceImpl;
import com.inhouse.trackthefood.services.Impl.WeightServiceImpl;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(path = "/weight")
public class WeightController {

    @Autowired
    WeightServiceImpl weightServiceImpl;

    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/{id}")
    public Weight getWeight(@PathVariable long id) {
        return weightServiceImpl.getWeight(id);
    }

    @PostMapping("/add")
    public Weight addWeight(@Valid @RequestBody Weight weight) {
        // userServiceImpl.getUser(weight.getUserId()).setWeight(weight.getWeight());
        return weightServiceImpl.addWeight(weight);
    }
    

    @GetMapping("/getOneDay/{id}")
    public List<Weight> getWeightsOneDayFrom(@PathVariable long id, @RequestParam(name = "date") Date date) {
        // System.out.println(date);
        return weightServiceImpl.getOneDay(date, id);
    }
    
    @GetMapping("/getMultiDays/{id}")
    public List<Weight> getWeightsMultiDaysFrom(@PathVariable long id, @RequestParam(name = "date") Date date, @RequestParam(name = "daysOffset") long offset) {
        // System.out.println(date);
        return weightServiceImpl.getMultiDays(date, id, offset);
    }
    
    
}
