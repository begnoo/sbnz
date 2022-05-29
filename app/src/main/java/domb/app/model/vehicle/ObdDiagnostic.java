package domb.app.model.vehicle;

import domb.sbnz.model.BaseEntity;

import java.util.List;

public class ObdDiagnostic extends BaseEntity {
    private List<Sensor> sensors;
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
