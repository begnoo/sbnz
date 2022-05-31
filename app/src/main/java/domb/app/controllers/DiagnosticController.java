package domb.app.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domb.app.model.vehicle.Vehicle;
import domb.app.requests.UserDiagnosticRequest;
import domb.app.services.DiagnoseService;

@RestController
@RequestMapping("/diagnose")
public class DiagnosticController {
    
    private DiagnoseService diagnoseService;
    private ModelMapper modelMapper;

    @Autowired
    public DiagnosticController(DiagnoseService diagnoseService, ModelMapper modelMapper) {
        this.diagnoseService = diagnoseService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void userDiagnose(@RequestBody UserDiagnosticRequest request) {
        Vehicle vehicle = modelMapper.map(request, Vehicle.class);
        this.diagnoseService.diagnoseBasedOnUserData(vehicle);
    }

}
