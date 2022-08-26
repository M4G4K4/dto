package com.korber.dto.scripts.csv.parser;

import com.korber.dto.model.data.ZoneRepository;
import com.korber.dto.model.jpa.Zone;
import com.korber.dto.model.mapper.ZoneMapper;
import com.korber.dto.scripts.csv.bean.ZoneCsv;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ZoneParser implements Parser {

    @Autowired
    private ZoneRepository repository;

    @Autowired
    private ZoneMapper mapper;

    private final List<Zone> zones = new ArrayList<>();

    @Override
    public void parse(final String fileName) throws FileNotFoundException {
        final List<ZoneCsv> zoneCsvList = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(ZoneCsv.class)
                .build()
                .parse();

        zones.addAll(zoneCsvList.stream()
                .map(item -> Zone.builder()
                        .id(Long.parseLong(item.getLocationId()))
                        .borough(item.getBorough())
                        .zone(item.getZone())
                        .serviceZone(item.getService_zone())
                        .build())
                .toList());
    }

    @Override
    public void persist() {
        repository.saveAll(zones);
    }


}

