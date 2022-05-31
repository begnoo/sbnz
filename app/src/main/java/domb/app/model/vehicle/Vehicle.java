package domb.app.model.vehicle;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import domb.app.model.BaseEntity;
import domb.app.model.statuses.FeelEnum;
import domb.app.model.statuses.LookEnum;
import domb.app.model.statuses.NotWorkingEnum;
import domb.app.model.statuses.SmellEnum;
import domb.app.model.statuses.SoundEnum;

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

    @ElementCollection
    private List<SoundEnum> sound;

    @ElementCollection
    private List<LookEnum> look;
    
    @ElementCollection
    private List<SmellEnum> smell;
    
    @ElementCollection
    private List<FeelEnum> feel;
    
    @ElementCollection
    private List<NotWorkingEnum> notWorking;


    public Vehicle() {
    }


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


    public List<SoundEnum> getSound() {
        return this.sound;
    }

    public void setSound(List<SoundEnum> sound) {
        this.sound = sound;
    }

    public List<LookEnum> getLook() {
        return this.look;
    }

    public void setLook(List<LookEnum> look) {
        this.look = look;
    }

    public List<SmellEnum> getSmell() {
        return this.smell;
    }

    public void setSmell(List<SmellEnum> smell) {
        this.smell = smell;
    }

    public List<FeelEnum> getFeel() {
        return this.feel;
    }

    public void setFeel(List<FeelEnum> feel) {
        this.feel = feel;
    }

    public List<NotWorkingEnum> getNotWorking() {
        return this.notWorking;
    }

    public void setNotWorking(List<NotWorkingEnum> notWorking) {
        this.notWorking = notWorking;
    }

}
