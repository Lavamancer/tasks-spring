package com.example.tasks.service;

import com.example.tasks.domain.Log;
import com.example.tasks.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LogService {

    @Autowired LogRepository logRepository;


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void create(Log.Type type, String message) {
        Log log = new Log();
        log.setType(type);
        log.setMessage(message);
        logRepository.save(log);
    }

}
