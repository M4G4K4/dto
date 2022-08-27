package com.korber.dto.web;

import com.korber.dto.service.ZonesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zone")
public class ZonesController {

    //TODO: Implement handler to show exception in spring boot response
    //TODO: Make File parse and save async

    @Autowired
    private ZonesService service;

    //TODO: Receive order parameter (dropoffs , pickups)
    @GetMapping("/top-zones")
    public ResponseEntity topZones(@Param("order") final String order) {
        return new ResponseEntity<>(service.topZones(order), HttpStatus.OK);
    }

    /**
     * TODO: Add parameters
     * zone : value must be the zone id of any of the available zones
     * date : value must be a date
     *
     * @return
     */
    @GetMapping("/zone-trips")
    public ResponseEntity<String> zoneTrips() {
        return new ResponseEntity<>("zone-trips", HttpStatus.OK);
    }
}
