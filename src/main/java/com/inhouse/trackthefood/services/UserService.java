package com.inhouse.trackthefood.services;

import org.springframework.stereotype.Service;

import com.inhouse.trackthefood.entities.Log;
import com.inhouse.trackthefood.entities.User;

@Service
public interface UserService {
    User getUser(Long id);
    User addUser(User user);
    Log addLog(Log log);
}