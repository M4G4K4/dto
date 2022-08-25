package com.korber.dto.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZonesController {

    @GetMapping("/top-zones")
    public ResponseEntity<String> topZones() {
        return new ResponseEntity<>("top-zones", HttpStatus.OK);
    }

    @GetMapping("/zone-trips")
    public ResponseEntity<String> zoneTrips() {
        return new ResponseEntity<>("zone-trips", HttpStatus.OK);
    }
}
