package com.korber.dto.service.utils;

import com.korber.dto.model.data.ZoneRepository;
import com.korber.dto.model.jpa.Zone;
import com.korber.dto.model.bean.ZoneCsv;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ZoneParser implements Parser {

    @Autowired
    private ZoneRepository repository;

    @Override
    public void parseAndSave(final MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            final List<ZoneCsv> zoneCsvList = new CsvToBeanBuilder(reader)
                    .withType(ZoneCsv.class)
                    .build()
                    .parse();

            final List<Zone> zones = new ArrayList<>(zoneCsvList.stream().skip(1).map(item -> Zone.builder()
                    .id(Long.parseLong(item.getLocationId()))
                    .borough(item.getBorough())
                    .zone(item.getZone())
                    .serviceZone(item.getService_zone())
                    .build()).toList());

            repository.saveAll(zones);

        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

}

