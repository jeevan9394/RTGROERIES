package com.example.jeevan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jeevan.services.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/api/measurementTypes")
public class MeasurementController {

    @Autowired
    private MeasurementService measurementService;

    @GetMapping("/get")
    public List<String> getAllMeasurementTypes() {
        return measurementService.getAllMeasurementTypes();
    }
}
