package com.inhouse.trackthefood.services.Impl;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inhouse.trackthefood.entities.Weight;
import com.inhouse.trackthefood.exceptions.ItemNotFoundException;
import com.inhouse.trackthefood.repositories.WeightRepository;
import com.inhouse.trackthefood.services.WeightService;

@Service
public class WeightServiceImpl implements WeightService {

    @Autowired
    WeightRepository weightRepository;

    @Override
    public Weight getWeight(long id) {
        return weightRepository.findById(id).orElseThrow(ItemNotFoundException::new);    
    }

    @Override
    public Weight addWeight(Weight weight) {
       return weightRepository.save(weight);
    }
    
    @Override
    public List<Weight> getOneDay(Date date, long userId) {
        
        return weightRepository.findAllByUserIdAndDateBetween(userId, new Date(LocalDate.parse(date.toString()).minusDays(1).toEpochDay()), date);
    }

    @Override
    public List<Weight> getMultiDays(Date date, long userId, long daysOffset) {
        System.out.println(LocalDate.parse(date.toString()).toString());
        LocalDate preCalDate = LocalDate.parse(date.toString()).minusDays(daysOffset);
        System.out.println(preCalDate);
        Date calDate = Date.valueOf(preCalDate);
        System.out.println(calDate);
        System.out.println(date);
        return weightRepository.findAllByUserIdAndDateBetween(userId, calDate, date);

    }
}
