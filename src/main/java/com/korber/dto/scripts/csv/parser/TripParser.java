package com.korber.dto.scripts.csv.parser;

import com.korber.dto.model.data.TripRepository;
import com.korber.dto.model.data.ZoneRepository;
import com.korber.dto.model.jpa.Trip;
import com.korber.dto.model.jpa.Zone;
import com.korber.dto.model.mapper.TripMapper;
import com.korber.dto.scripts.csv.bean.TripCsv;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TripParser implements Parser {


    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private ZoneRepository zoneRepository;

    @Autowired
    private TripMapper mapper;

    private final List<Trip> trips = new ArrayList<>();

    @Override
    public void parse(final String filePath) throws FileNotFoundException {
        final List<TripCsv> tripCsvList = new CsvToBeanBuilder(new FileReader(filePath))
                .withType(TripCsv.class)
                .build()
                .parse();

        trips.addAll(tripCsvList.stream()
                .map(item -> {
                    Optional<Zone> pickUpZone = zoneRepository.findById(Long.parseLong(item.getPickupZone()));
                    Optional<Zone> dropOffZone = zoneRepository.findById(Long.parseLong(item.getPickupZone()));

                    return Trip.builder()
                             .pickupAt(Instant.parse(item.getPickupAt()))
                             .dropOffAt(Instant.parse(item.getDropOffAt()))
                             .pickupZone(pickUpZone.orElse(null))
                             .dropOffZone(dropOffZone.orElse(null))
                             .build();
                })
                .toList());
    }

    @Override
    public void persist() {
        tripRepository.saveAll(trips);
    }

}
