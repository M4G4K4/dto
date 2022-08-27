package com.korber.dto.service.events.csv;

import com.korber.dto.model.data.ZoneRepository;
import com.korber.dto.model.dto.async.ReadCsvEvent;
import com.korber.dto.utilities.parser.Parser;
import com.korber.dto.utilities.parser.TripGreenParser;
import com.korber.dto.utilities.parser.TripYellowParser;
import com.korber.dto.utilities.parser.ZoneParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ReadCsvEventListner {


    @Autowired
    protected TripYellowParser tripYellowParser;

    @Autowired
    protected TripGreenParser tripGreenParser;

    @Autowired
    protected ZoneRepository repository;

    @Autowired
    protected ZoneParser zoneParser;

    @Async
    @EventListener
    public void readCsv(final ReadCsvEvent event) {
        final Parser parser = getParser(event.getFile());
        parser.parseAndSave(event.getFile());
    }

    private Parser getParser(final MultipartFile file) {
        final Parser parser;

        if (file.getOriginalFilename().contains("yellow")) {
            parser = tripYellowParser;
        } else if (file.getOriginalFilename().contains("green")) {
            parser = tripGreenParser;
        } else {
            parser = zoneParser;
        }

        return parser;
    }
}
