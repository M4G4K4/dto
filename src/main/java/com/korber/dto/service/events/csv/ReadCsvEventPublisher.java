package com.korber.dto.service.events.csv;

import com.korber.dto.model.dto.async.ReadCsvEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ReadCsvEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    ReadCsvEventPublisher(ApplicationEventPublisher publisher) {
        this.eventPublisher = publisher;
    }

    public void readCsv(ReadCsvEvent event) {
        eventPublisher.publishEvent(event);
    }
}
