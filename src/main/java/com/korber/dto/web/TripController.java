package com.korber.dto.web;

import com.korber.dto.model.dto.trip.TripList;
import com.korber.dto.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripService service;

    @GetMapping("/list-yellow")
    public ResponseEntity<TripList> topZones(@QueryParam("page") final Integer page, @QueryParam("perPage") final Integer perPage, @QueryParam("order") final String order) {
        return new ResponseEntity<>(service.getYellowTrips(page, perPage, order), HttpStatus.OK);
    }
}
