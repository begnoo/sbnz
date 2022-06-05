package domb.app.services;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domb.app.model.Instructions;
import domb.app.model.enums.PartEnum;
import domb.app.model.vehicle.Failure;
import domb.app.repositories.FailureRepository;
import domb.app.repositories.InstructionsRepository;
@Service
public class DiagnoseService {
  
    private final KieContainer kieContainer;
    private final FailureRepository failureRepository;
    private final InstructionsRepository instructionRepository;


    @Autowired
    public DiagnoseService(KieContainer kieContainer, FailureRepository failureRepository, InstructionsRepository instructionsRepository) {
        super();
        this.kieContainer = kieContainer;
        this.failureRepository = failureRepository;
        this.instructionRepository = instructionsRepository;
    }

    public Instructions diagnoseBasedOnUserData(Failure failure) {

        System.out.println(failure.getId());
        List<Failure> releatedFailures = failureRepository.findByVehicleManufacturerAndVehicleModel(failure.getVehicleManufacturer(), failure.getVehicleModel())
                                        .orElse(new ArrayList<Failure>());
        failure.setReleatedFailures(releatedFailures);

        System.out.println(failure.getReleatedFailures().size());

        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(failure);
        kieSession.fireAllRules();
        kieSession.dispose();

        if (failure.getPart() != PartEnum.NONE) {
            failureRepository.save(failure);
        }

        return instructionRepository.findByPart(failure.getPart()).orNull();
    }

}