package com.korber.dto.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZonesController {

    //TODO: Receive order parameter (dropoffs , pickups)
    @GetMapping("/top-zones")
    public ResponseEntity<String> topZones() {
        return new ResponseEntity<>("top-zones", HttpStatus.OK);
    }

    /**
     * TODO: Add parameters
     * zone : value must be the zone id of any of the available zones
     * date : value must be a date
     * @return
     */
    @GetMapping("/zone-trips")
    public ResponseEntity<String> zoneTrips() {
        return new ResponseEntity<>("zone-trips", HttpStatus.OK);
    }
}
