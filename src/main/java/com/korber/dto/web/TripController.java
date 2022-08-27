package com.korber.dto.web;

import com.korber.dto.model.dto.trip.TripList;
import com.korber.dto.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripService service;

    @GetMapping("/list-yellow")
    public ResponseEntity<TripList> topZones(@RequestParam(name = "page", required = false, defaultValue = "1") final Integer page,
                                             @RequestParam(name = "perPage", required = false, defaultValue = "10") final Integer perPage,
                                             @RequestParam(name = "order", required = false, defaultValue = "id") final String order) {
        return new ResponseEntity<>(service.getYellowTrips(page, perPage, order), HttpStatus.OK);
    }
}
