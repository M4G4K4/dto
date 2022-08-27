package com.korber.dto.service;

import com.korber.dto.model.data.ZoneRepository;
import com.korber.dto.model.dto.async.ReadCsvEvent;
import com.korber.dto.service.events.csv.ReadCsvEventPublisher;
import com.korber.dto.utilities.exceptions.ErrorCode;
import com.korber.dto.utilities.exceptions.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class FileService {

    @Autowired
    protected ZoneRepository repository;

    @Autowired
    protected ReadCsvEventPublisher eventPublisher;

    public void readCsv(final MultipartFile file) {
        verifications(file);
        eventPublisher.readCsv(ReadCsvEvent.builder()
                .file(file)
                .build());
    }

    private void verifications(final MultipartFile file) {
        if (!"text/csv".equals(file.getContentType())) {
            throw new ServiceException(ErrorCode.FILE_TYPE_NOT_SUPPORTED);
        }

        if (!file.getOriginalFilename().contains("zones")) {
            if (repository.findAll().isEmpty()) {
                throw new ServiceException(ErrorCode.FILE_ZONES_FRIST_IMPORT);
            }
        }
    }
}
