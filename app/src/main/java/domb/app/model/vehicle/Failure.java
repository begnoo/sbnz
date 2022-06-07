package domb.app.model.vehicle;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.kie.api.definition.type.Role;

import domb.app.model.BaseEntity;
import domb.app.model.enums.PartEnum;

@Entity
@SQLDelete(sql = "UPDATE failure SET active = false WHERE id = ?")
@Where(clause = "active = true")
@Role(Role.Type.EVENT)
public class Failure extends BaseEntity {

    @Column
    private PartEnum part;

    @Column
    private String vehicleManufacturer;
    
    @Column
    private String vehicleModel;

    @Column
    private String vehicleYear;

    @Column(columnDefinition = "boolean default false")
    private boolean used;

    @Transient
    private List<Failure> releatedFailures;

    @Transient
    private long questionId;
    
    @Transient
    private String answerValue;

    public Failure() {
    }

    public PartEnum getPart() {
        return this.part;
    }

    public void setPart(PartEnum part) {
        this.part = part;
    }

    public long getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }


    public String getAnswerValue() {
        return this.answerValue;
    }

    public void setAnswerValue(String answerValue) {
        this.answerValue = answerValue;
    }


    public String getVehicleManufacturer() {
        return this.vehicleManufacturer;
    }

    public void setVehicleManufacturer(String vehicleManufacturer) {
        this.vehicleManufacturer = vehicleManufacturer;
    }

    public String getVehicleModel() {
        return this.vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleYear() {
        return this.vehicleYear;
    }

    public void setVehicleYear(String vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public List<Failure> getReleatedFailures() {
        return this.releatedFailures;
    }

    public void setReleatedFailures(List<Failure> releatedFailures) {
        this.releatedFailures = releatedFailures;
    }    

    public boolean isUsed() {
        return this.used;
    }

    public boolean getUsed() {
        return this.used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

}
