package com.korber.dto.model.data;

import com.korber.dto.model.jpa.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    Page<Trip> findAllByType(Pageable pageable, String type);
}
