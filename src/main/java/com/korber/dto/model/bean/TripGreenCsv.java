package com.korber.dto.model.bean;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TripGreenCsv {
    @CsvBindByPosition(position = 1)
    private String pickupAt;

    @CsvBindByPosition(position = 2)
    private String dropOffAt;

    @CsvBindByPosition(position = 5)
    private String pickupZone;

    @CsvBindByPosition(position = 6)
    private String dropOffZone;
}
