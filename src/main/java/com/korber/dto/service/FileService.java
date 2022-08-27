package com.korber.dto.service;

import com.korber.dto.model.data.ZoneRepository;
import com.korber.dto.model.dto.zone.ZoneRead;
import com.korber.dto.service.utils.Parser;
import com.korber.dto.service.utils.TripGreenParser;
import com.korber.dto.service.utils.TripYellowParser;
import com.korber.dto.service.utils.ZoneParser;
import com.korber.dto.utilities.exceptions.ErrorCode;
import com.korber.dto.utilities.exceptions.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

@Slf4j
@Service
public class FileService {

    @Autowired
    protected TripYellowParser tripYellowParser;

    @Autowired
    protected TripGreenParser tripGreenParser;

    @Autowired
    protected ZoneRepository repository;

    @Autowired
    protected ZoneParser zoneParser;

    //TODO: Make it async

    @Transactional
    public void readCsv(final MultipartFile file) {
        verifications(file);
        final Parser parser = getParser(file);
        parser.parseAndSave(file);
    }

    private Parser getParser(final MultipartFile file) {
        final Parser parser;

        if (file.getOriginalFilename().contains("yellow")) {
            parser = tripYellowParser;
        }else if(file.getOriginalFilename().contains("green")){
            parser = tripGreenParser;
        }else  {
            parser = zoneParser;
        }

        return parser;
    }

    private void verifications(final MultipartFile file) {
        if (!"text/csv".equals(file.getContentType())) {
            throw new ServiceException(ErrorCode.FILE_TYPE_NOT_SUPPORTED);
        }

        if(!file.getOriginalFilename().contains("zones")){
            if(repository.findAll().isEmpty()){
                throw new ServiceException(ErrorCode.FILE_ZONES_FRIST_IMPORT);
            }
        }
    }
}
