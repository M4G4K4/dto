package com.korber.dto.model.dto.trip;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TripList {
    private int perPage;
    private int page;
    private long total;
    private int totalPages;
    private List<TripRead> items;
}
