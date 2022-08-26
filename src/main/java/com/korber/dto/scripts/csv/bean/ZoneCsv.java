package com.korber.dto.scripts.csv.bean;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZoneCsv {
    @CsvBindByPosition(position = 0)
    private String locationId;

    @CsvBindByPosition(position = 1)
    private String Borough;

    @CsvBindByPosition(position = 2)
    private String Zone;

    @CsvBindByPosition(position = 3)
    private String service_zone;

}
