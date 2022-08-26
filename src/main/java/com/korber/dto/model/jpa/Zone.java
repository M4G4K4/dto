package com.korber.dto.model.jpa;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
