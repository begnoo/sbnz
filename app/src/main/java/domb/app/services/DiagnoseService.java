package domb.app.services;

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

        System.out.println(failure.getQuestionId());
        System.out.println(failure.getAnswerValue());
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(failure);
        kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println(failure.getPart());

        if (failure.getPart() != PartEnum.NONE) {
            failureRepository.save(failure);
        }

        return instructionRepository.findByPart(failure.getPart()).orNull();
    }

}
