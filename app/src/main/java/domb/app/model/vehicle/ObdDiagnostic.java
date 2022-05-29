package domb.app.model.vehicle;

import domb.app.model.BaseEntity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class ObdDiagnostic extends BaseEntity {
    
    @OneToMany
    private List<Sensor> sensors;
    
    @ElementCollection
    private List<String> faultCodes;

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public List<String> getFaultCodes() {
        return faultCodes;
    }

    public void setFaultCodes(List<String> faultCodes) {
        this.faultCodes = faultCodes;
    }
}
