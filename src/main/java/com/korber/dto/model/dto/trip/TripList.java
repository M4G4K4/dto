package com.korber.dto.model.dto.trip;

import lombok.Setter;

import java.util.List;

@Setter
public class TripList {
    private int perPage;
    private int page;
    private int total;
    private List<TripRead> items;
}
