package domb.app.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domb.app.model.Instructions;
import domb.app.model.vehicle.Failure;
import domb.app.requests.FailureRequest;
import domb.app.responses.InstructionsResponse;
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
    public ResponseEntity<InstructionsResponse> userDiagnose(@RequestBody FailureRequest request) {
        Failure failure = modelMapper.map(request, Failure.class);
        failure.setId(null);
        System.out.println(failure);
        Instructions instructions = this.diagnoseService.diagnoseBasedOnUserData(failure);
        
        return new ResponseEntity<>(this.modelMapper.map(instructions, InstructionsResponse.class), HttpStatus.OK);
    }

}
