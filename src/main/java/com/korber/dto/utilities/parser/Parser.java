package com.korber.dto.utilities.parser;

import org.springframework.web.multipart.MultipartFile;

public interface Parser {

    void parseAndSave(MultipartFile file);
}
