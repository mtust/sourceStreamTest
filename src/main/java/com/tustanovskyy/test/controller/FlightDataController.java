package com.tustanovskyy.test.controller;

import com.tustanovskyy.test.domain.FlightData;
import com.tustanovskyy.test.service.FlightDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightDataController {

    @Autowired
    private FlightDataService flightDataService;

    @GetMapping("flightData")
    public List<FlightData> getFlightData() throws Exception {
        return flightDataService.parseCsv();
    }

    @GetMapping
    public String home() {
        return "home";
    }

}
