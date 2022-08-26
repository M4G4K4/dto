package com.korber.dto.model.dto.trip;

import lombok.Setter;

@Setter
public class TripRead {
    private long id;
    private String pickUpAt;
    private String getPickUpAt;
    private String pickUpZone;
    private String dropOffZone;
    private String type;
}
