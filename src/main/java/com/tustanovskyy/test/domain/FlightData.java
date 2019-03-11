package com.tustanovskyy.test.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
public class FlightData {

    private LocalTime departureTime;
    private String destination;
    private String destenitionIATA;
    private String flightNo;
    private Boolean sunday;
    private Boolean monday;
    private Boolean tuesday;
    private Boolean wednsday;
    private Boolean thursday;
    private Boolean friday;
    private Boolean saturday;

}