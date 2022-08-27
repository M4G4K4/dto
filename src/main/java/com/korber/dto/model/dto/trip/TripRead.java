package com.korber.dto.model.dto.trip;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
public class TripRead {
    private Long id;

    @JsonFormat(timezone = "UTC", pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonSerialize(using = InstantSerializer.class)
    private Instant pickupAt;

    @JsonFormat(timezone = "UTC", pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonSerialize(using = InstantSerializer.class)
    private Instant dropOffAt;

    private String pickUpZone;
    private String dropOffZone;
    private String type;
}
