package com.korber.dto.model.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class TripZoneId implements Serializable {
    @Column(name = "trip_id")
    private Long tripId;

    @Column(name = "zone_id")
    private Long zoneId;

    // DROPOFF or PICKUP
    private String type;
}
