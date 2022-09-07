package com.korber.dto.model.jpa;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Table(name = "zones")
@NoArgsConstructor
@AllArgsConstructor
public class Zone {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String borough;

    private String zone;

    @Column(name = "service_zone")
    private String serviceZone;

    // New implementation
    @OneToMany(mappedBy = "zone")
    private List<TripZone> trips = new ArrayList<>();
}
