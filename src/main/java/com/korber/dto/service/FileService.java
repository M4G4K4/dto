package com.korber.dto.service;

import com.korber.dto.service.utils.Parser;
import com.korber.dto.service.utils.TripParser;
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
    protected TripParser tripParser;

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

        if (file.getOriginalFilename().contains("yellow") || file.getOriginalFilename().contains("green")) {
            parser = tripParser;
        } else {
            parser = zoneParser;
        }

        return parser;
    }

    private void verifications(final MultipartFile file) {
        if (!"text/csv".equals(file.getContentType())) {
            throw new ServiceException(ErrorCode.FILE_TYPE_NOT_SUPPORTED);
        }
    }
}
