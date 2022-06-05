package domb.app.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domb.app.model.vehicle.Failure;
import domb.app.repositories.FailureRepository;
@Service
public class DiagnoseService {
  
    private final KieContainer kieContainer;
    private final FailureRepository failureRepository;

    @Autowired
    public DiagnoseService(KieContainer kieContainer, FailureRepository failureRepository) {
        super();
        this.kieContainer = kieContainer;
        this.failureRepository = failureRepository;
    }

    public void diagnoseBasedOnUserData(Failure failure) {

        System.out.println(failure.getQuestionId());
        System.out.println(failure.getAnswerValue());
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(failure);
        kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println(failure.getPart());
        failureRepository.save(failure);
    }

}
