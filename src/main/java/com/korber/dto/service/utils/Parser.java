package com.korber.dto.service.utils;

import org.springframework.web.multipart.MultipartFile;

public interface Parser {

    void parseAndSave(MultipartFile file);
}
