package com.korber.dto.model.jpa;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Table(name = "trips")
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "pickup_at")
    private Instant pickupAt;

    @Column(name = "drop_off_at")
    private Instant dropOffAt;

    @OneToOne
    @JoinColumn(name = "pickup_zone_id", referencedColumnName = "id")
    private Zone pickupZone;

    @OneToOne
    @JoinColumn(name = "dropoff_zone_id", referencedColumnName = "id")
    private Zone dropOffZone;

    private String type;





    // New implementation
    @OneToMany(mappedBy = "trip")
    private List<TripZone> zones = new ArrayList<>();

}
