package com.inhouse.trackthefood.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inhouse.trackthefood.Exceptions.LogNotFoundException;
import com.inhouse.trackthefood.entities.Log;
import com.inhouse.trackthefood.repositories.LogRepository;
import com.inhouse.trackthefood.services.LogService;

@Service
public class LogServiceImpl implements LogService{

    @Autowired
    LogRepository logRepository;

    @Override
    public Log addLog(Log log) {
        return logRepository.save(log);
    }

    @Override
    public Log getLog(long id) {
        return logRepository.findById(id).orElseThrow(LogNotFoundException::new);
    }
    
}
