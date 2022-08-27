package com.korber.dto.model.bean;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@Builder
@Table(name = "trips")
@NoArgsConstructor
@AllArgsConstructor
public class TripJpaCsv {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "pickup_at")
    private Instant pickupAt;

    @Column(name = "drop_off_at")
    private Instant dropOffAt;


    @Column(name = "pickup_zone_id")
    private Long pickupZoneId;

    @Column(name = "dropoff_zone_id")
    private Long dropOffZoneId;

    private String type;
}
