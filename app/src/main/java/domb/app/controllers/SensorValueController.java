package domb.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domb.app.model.vehicle.SensorValue;
import domb.app.services.SensorValueService;

@RestController
@RequestMapping("/sensor-values")
public class SensorValueController {
    
    private SensorValueService sensorValueService;

    @Autowired
    public SensorValueController(SensorValueService sensorValueService) {
        this.sensorValueService = sensorValueService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addValue(@RequestBody SensorValue sensorValue) {
        return new ResponseEntity<>(this.sensorValueService.addValue(sensorValue), HttpStatus.OK);
    }
    
}
