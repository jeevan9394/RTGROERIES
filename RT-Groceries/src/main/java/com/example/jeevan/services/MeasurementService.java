package com.example.jeevan.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MeasurementService {

    public List<String> getAllMeasurementTypes() {
        
        return Arrays.asList("lbs", "kgs", "pounds", "litres", "ounces");
    }
}
