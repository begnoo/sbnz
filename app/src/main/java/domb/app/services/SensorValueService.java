package domb.app.services;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domb.app.model.vehicle.SensorValue;

@Service
public class SensorValueService {
    private final KieSession kieSession;

    @Autowired
    public SensorValueService(KieSession kieSession) {
        super();
        this.kieSession = kieSession;
    }

    public String addValue(SensorValue sensorValue) {
        kieSession.insert(sensorValue);
        kieSession.fireAllRules();
        return "Added value";
    }
}
