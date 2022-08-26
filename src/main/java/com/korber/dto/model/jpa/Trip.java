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
    private Long id;

    private Instant pickupAt;

    private Instant dropOffAt;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Zone pickupZone;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Zone dropOffZone;

    private String type;
}
