package com.korber.dto.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
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
