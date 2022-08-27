package com.korber.dto.service;

import com.korber.dto.model.data.ZoneRepository;
import com.korber.dto.model.dto.zone.ZoneRead;
import com.korber.dto.model.jpa.Zone;
import com.korber.dto.utilities.exceptions.ErrorCode;
import com.korber.dto.utilities.exceptions.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ZonesService {

    @Autowired
    protected ZoneRepository repository;


    public ZoneRead topZones(final String order){



        return new ZoneRead();
    }
}
