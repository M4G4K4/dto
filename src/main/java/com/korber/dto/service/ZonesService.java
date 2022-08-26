package com.korber.dto.service;

import com.korber.dto.model.data.ZoneRepository;
import com.korber.dto.model.jpa.Zone;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ZonesService {

    @Autowired
    protected ZoneRepository repository;


    public void cenas() {
        final Optional<Zone> zone = repository.findById(Long.parseLong("1"));
        // Do the .orElseThrow(()-> ServiceException());

    }
}
