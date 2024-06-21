package com.inhouse.trackthefood.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.inhouse.trackthefood.Helpers.UserHelper;
import com.inhouse.trackthefood.entities.Log;
import com.inhouse.trackthefood.entities.User;
import com.inhouse.trackthefood.entities.Weight;
import com.inhouse.trackthefood.services.Impl.LogServiceImpl;
import com.inhouse.trackthefood.services.Impl.UserServiceImpl;
import com.inhouse.trackthefood.services.Impl.WeightServiceImpl;

import jakarta.validation.Valid;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;





@RestController()
@RequestMapping("/user")
public class UserController {

        @Autowired
        UserServiceImpl userServiceImpl;

        @Autowired
        LogServiceImpl logServiceImpl;

        @Autowired
        UserHelper userHelper;

        @Autowired
        WeightServiceImpl weightServiceImpl;

        @GetMapping("/{id}")
        public User getUser(@PathVariable long id) {
            return userServiceImpl.getUser(id);
        }

        @PostMapping("/join")
        public User joinUser(@Valid @RequestBody User user) {
            user = userHelper.handleUserWeightUpdate(userServiceImpl.addUser(user));
            Weight weight = new Weight();
            weight.setDate(new Date(Instant.now().toEpochMilli()));
            weight.setUserId(user.getId());
            weight.setWeight(user.getWeight());
            weightServiceImpl.addWeight(weight);
            return user;
        }

        @PostMapping("/updateWeight/{id}")
        public User updateWeight(@PathVariable long id, @RequestBody float weight) {
            User user = userServiceImpl.getUser(id);
            user.setWeight(weight);
            return userHelper.handleUserWeightUpdate(user);            
        }
        

        @PostMapping("/update/{id}")
        public User postMethodName(@RequestBody User user, @PathVariable long id) {
            user.setId(id);
            return userServiceImpl.addUser(user);            
        }
        

        @PostMapping("/log")
        public Log addNewLog(@Valid @RequestBody Log log) {
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

        
        @GetMapping("/bmr")
        public ResponseEntity<Integer> getBMR(@RequestParam int age, @RequestParam float weight, @RequestParam float height) {
            return ResponseEntity.ok(userHelper.calculateBMR(age, height, weight));
        }

        @GetMapping("/bmi")
        public Map<String, Object> getBMI(@RequestParam int age, @RequestParam float weight, @RequestParam float height) {
            return userHelper.calculateBMI(age, height, weight);
        }

        @GetMapping("/bmr/{id}")
        public ResponseEntity<Integer> getBMR2(@PathVariable long id) {
            User user = userServiceImpl.getUser(id);
            int age = user.getAge();
            float weight = user.getWeight();
            float height = user.getHeight();

            return ResponseEntity.ok(userHelper.calculateBMR(age, height, weight));
        }

        @GetMapping("/bmi/{id}")
        public Map<String, Object> getBMI2(@PathVariable long id) {
            User user = userServiceImpl.getUser(id);
            int age = user.getAge();
            float weight = user.getWeight();
            float height = user.getHeight();
            return userHelper.calculateBMI(age, height, weight);
        }
        

        
        
        
}
