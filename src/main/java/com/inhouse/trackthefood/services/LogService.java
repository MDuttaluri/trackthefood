package com.inhouse.trackthefood.services;

import org.springframework.stereotype.Service;

import com.inhouse.trackthefood.entities.Log;

@Service
public interface LogService {
    Log addLog(Log log);
    Log getLog(long id);
}
