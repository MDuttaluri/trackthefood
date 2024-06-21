package com.inhouse.trackthefood.services;

import java.sql.Date;
import java.util.List;

import com.inhouse.trackthefood.entities.Weight;

public interface WeightService {
    Weight getWeight(long id);
    Weight addWeight(Weight weight);
    List<Weight> getOneDay(Date date, long userId);
    List<Weight> getMultiDays(Date date, long userId, long daysOffset);

}
