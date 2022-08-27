package com.korber.dto.model.dto.async;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class ReadCsvEvent {
    private MultipartFile file;
}
