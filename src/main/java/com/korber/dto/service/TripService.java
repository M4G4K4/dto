package com.korber.dto.service;

import com.korber.dto.model.comom.TripType;
import com.korber.dto.model.data.TripRepository;
import com.korber.dto.model.dto.trip.TripList;
import com.korber.dto.model.dto.trip.TripRead;
import com.korber.dto.model.jpa.Trip;
import com.korber.dto.model.mapper.TripMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TripService {

    @Autowired
    protected TripMapper mapper;

    @Autowired
    protected TripRepository repository;

    public TripList getYellowTrips(final Integer page, final Integer perPage, final String orderBy) {

        final Pageable pageable = PageRequest.of(page - 1, perPage, Sort.by(orderBy).descending());

        final Page<Trip> tripList = repository.findAllByType(pageable, TripType.YELLOW.name());

        final List<TripRead> tripReadList = tripList.get().map(mapper::tripToTripRead).toList();

        return TripList.builder()
                .perPage(perPage)
                .page(page)
                .total(tripList.getTotalElements())
                .totalPages(tripList.getTotalPages())
                .items(tripReadList)
                .build();
    }
}
