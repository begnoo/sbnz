package domb.app.services;

import java.util.ArrayList;
import java.util.List;

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
  
    private final KieSession kieSession;
    private final FailureRepository failureRepository;
    private final InstructionsRepository instructionRepository;

    @Autowired
    public DiagnoseService(KieSession kieSession, FailureRepository failureRepository, InstructionsRepository instructionsRepository) {
        super();
        this.kieSession = kieSession;
        this.failureRepository = failureRepository;
        this.instructionRepository = instructionsRepository;
    }

    public Instructions diagnoseBasedOnUserData(Failure failure) {

        List<Failure> releatedFailures = failureRepository.findByVehicleManufacturerAndVehicleModel(failure.getVehicleManufacturer(), failure.getVehicleModel())
                                        .orElse(new ArrayList<Failure>());
        failure.setReleatedFailures(releatedFailures);

        kieSession.insert(failure);
        kieSession.fireAllRules();
        System.out.println("Fact Count: " + kieSession.getFactCount());
        // kieSession.dispose();

        if (failure.getPart() != PartEnum.NONE) {
            failureRepository.save(failure);
        }
        
        Instructions instr = instructionRepository.findByPart(failure.getPart()).orNull();
        return instr != null ? instr : new Instructions("The system could not detect your car malfunction. Visit your mechanic.", PartEnum.UNKNOWN);
    }

}
