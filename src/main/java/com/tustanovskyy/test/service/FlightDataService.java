package com.tustanovskyy.test.service;

import com.opencsv.CSVReader;
import com.tustanovskyy.test.domain.FlightData;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class FlightDataService {


    public List<FlightData> parseCsv() throws Exception {

        Resource resource = new ClassPathResource("flights.csv");
        InputStream resourceInputStream = resource.getInputStream();
        CSVReader reader = new CSVReader(new InputStreamReader(resourceInputStream, StandardCharsets.UTF_8), ',');
        List<FlightData> flightDataList = new ArrayList<>();
        //read all lines at once
        List<String[]> records = reader.readAll();

        Iterator<String[]> iterator = records.iterator();
        //skip header row
        iterator.next();
        while(iterator.hasNext()) {
            String[] line = iterator.next();
           flightDataList.add(createFlightData(line));
        }
        return flightDataList;
    }

    private FlightData createFlightData(String[] line) {
        FlightData flightData = new FlightData();
        flightData.setDepartureTime(LocalTime.parse(line[0]));
        flightData.setDestination(line[1]);
        flightData.setDestenitionIATA(line[2]);
        flightData.setFlightNo(line[3]);
        flightData.setSunday(line[4].contains("x"));
        flightData.setMonday(line[5].contains("x"));
        flightData.setTuesday(line[6].contains("x"));
        flightData.setWednsday(line[7].contains("x"));
        flightData.setThursday(line[8].contains("x"));
        flightData.setFriday(line[9].contains("x"));
        flightData.setSaturday(line[10].contains("x"));
        return flightData;
    }
}
