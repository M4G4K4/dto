package com.korber.dto.model.dto.zone;

import lombok.Setter;

@Setter
public class ZoneTripRead {
    private String zone;
    private String date;

    //TODO: Change this in json to: pu
    private int pickUp;
    //TODO: Change this in json to: do
    private int dropOff;
}
