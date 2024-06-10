package com.inhouse.trackthefood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inhouse.trackthefood.entities.Log;

public interface LogRepository extends JpaRepository<Log, Long>{

    
} 