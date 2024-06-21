package com.inhouse.trackthefood.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inhouse.trackthefood.entities.Weight;

public interface WeightRepository extends JpaRepository<Weight, Long>{

    List<Weight> findAllByUserIdAndDateBetween(long id, Date date1, Date date2);
}
