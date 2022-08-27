package com.korber.dto.model.data;

import com.korber.dto.model.bean.TripJpaCsv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripCsvRepository extends JpaRepository<TripJpaCsv, Long> {
}
