package domb.app.model.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import domb.app.model.BaseEntity;

@Entity
@SQLDelete(sql = "UPDATE vehicle SET active = false WHERE id = ?")
@Where(clause = "active = true")
public class Vehicle extends BaseEntity {

    @Column
    private String model;
    
    @Column
    private String manufacturer;
    
    @Column
    private String engineModel;
    
    @OneToOne
    private FailureHistory failuresHistory;
    
    @OneToOne
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
