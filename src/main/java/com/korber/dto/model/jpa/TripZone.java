package com.korber.dto.model.jpa;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "zones")
@NoArgsConstructor
@AllArgsConstructor
public class TripZone {

    @EmbeddedId
    private TripZoneId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tripId")
    private Trip trip;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("zoneId")
    private Zone zone;

    private String type;
}
