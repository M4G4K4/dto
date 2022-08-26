package com.korber.dto.service;

import com.korber.dto.model.data.ZoneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TripService {

    @Autowired
    protected ZoneRepository repository;

    public void someMethod() {

    }
}
