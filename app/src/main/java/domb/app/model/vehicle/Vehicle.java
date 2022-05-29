package domb.app.model.vehicle;

import domb.app.model.BaseEntity;

public class Vehicle extends BaseEntity {

    private String model;
    private String manufacturer;
    private String engineModel;
    private FailureHistory failuresHistory;
    private ObdDiagnostic obdDiagnostic;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public FailureHistory getFailuresHistory() {
        return failuresHistory;
    }

    public void setFailuresHistory(FailureHistory failuresHistory) {
        this.failuresHistory = failuresHistory;
    }

    public ObdDiagnostic getObdDiagnostic() {
        return obdDiagnostic;
    }

    public void setObdDiagnostic(ObdDiagnostic obdDiagnostic) {
        this.obdDiagnostic = obdDiagnostic;
    }
}
