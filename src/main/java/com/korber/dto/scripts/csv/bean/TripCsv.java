package com.korber.dto.scripts.csv.bean;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TripCsv {
    @CsvBindByPosition(position = 1)
    private String pickupAt;

    @CsvBindByPosition(position = 2)
    private String dropOffAt;

    @CsvBindByPosition(position = 7)
    private String pickupZone;

    @CsvBindByPosition(position = 8)
    private String dropOffZone;
}
