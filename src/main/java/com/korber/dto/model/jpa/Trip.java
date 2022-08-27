package com.korber.dto.model.jpa;

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
public class Trip {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Instant pickupAt;

    private Instant dropOffAt;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Zone pickupZone;

    @Column(name = "pick_up_zone")
    private Long pickupZoneId;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Zone dropOffZone;

    @Column(name = "drop_off_zone")
    private Long dropOffZoneId;
}
