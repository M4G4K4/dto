package com.korber.dto.model.mapper;

import com.korber.dto.model.dto.trip.TripRead;
import com.korber.dto.model.jpa.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TripMapper {

    @Mapping(target = "pickUpZone", source = "pickupZone.zone")
    @Mapping(target = "dropOffZone", source = "dropOffZone.zone")
    TripRead tripToTripRead(Trip trip);


}
