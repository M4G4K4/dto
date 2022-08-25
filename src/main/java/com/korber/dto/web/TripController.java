package com.korber.dto.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TripController {

    @GetMapping("/list-yellow")
    public ResponseEntity<String> topZones() {
        return new ResponseEntity<>("list-yellow", HttpStatus.OK);
    }
}
