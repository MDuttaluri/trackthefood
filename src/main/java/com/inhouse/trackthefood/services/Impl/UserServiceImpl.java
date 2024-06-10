package com.inhouse.trackthefood.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inhouse.trackthefood.Exceptions.UserNotFoundException;
import com.inhouse.trackthefood.entities.Log;
import com.inhouse.trackthefood.entities.User;
import com.inhouse.trackthefood.repositories.UserRepository;
import com.inhouse.trackthefood.services.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    LogServiceImpl logServiceImpl;

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User addUser(User user) {
       return userRepository.save(user);
    }

    @Override
    public Log addLog(Log log) {
        return logServiceImpl.addLog(log);
    }

}
