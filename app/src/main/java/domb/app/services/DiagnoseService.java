package domb.app.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domb.app.model.vehicle.Vehicle;

@Service
public class DiagnoseService {
  
    private final KieContainer kieContainer;

    @Autowired
    public DiagnoseService(KieContainer kieContainer) {
        super();
        this.kieContainer = kieContainer;
    }

    public void diagnoseBasedOnUserData(Vehicle vehicle) {

        vehicle.setManufacturer("manufacturer");
        System.out.println(vehicle.getSound());
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(vehicle);
        kieSession.fireAllRules();
        kieSession.dispose();

    }

}
