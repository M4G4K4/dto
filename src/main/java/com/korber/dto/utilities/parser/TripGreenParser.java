package com.korber.dto.utilities.parser;

import com.korber.dto.model.bean.TripGreenCsv;
import com.korber.dto.model.comom.TripType;
import com.korber.dto.model.data.TripCsvRepository;
import com.korber.dto.model.bean.TripJpaCsv;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TripGreenParser implements Parser {


    @Autowired
    private TripCsvRepository tripRepository;

    @Override
    public void parseAndSave(final MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            final List<TripGreenCsv> tripCsvList = new CsvToBeanBuilder(reader)
                    .withType(TripGreenCsv.class)
                    .build()
                    .parse();

            final String tripType = file.getOriginalFilename().contains("yellow") ? TripType.YELLOW.name(): TripType.GREEN.name();

            final List<TripJpaCsv> trips = new ArrayList<>(tripCsvList.stream().limit(100).map(item -> {
                try {
                    return TripJpaCsv.builder()
                            .pickupAt(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(item.getPickupAt()).toInstant())
                            .dropOffAt(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(item.getDropOffAt()).toInstant())
                            .pickupZoneId(Long.parseLong(item.getPickupZone()))
                            .dropOffZoneId(Long.parseLong(item.getDropOffZone()))
                            .type(tripType)
                            .build();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }).toList());

            tripRepository.saveAll(trips);

        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}
