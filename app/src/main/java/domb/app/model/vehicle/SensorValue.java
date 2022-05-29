package domb.app.model.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;

import domb.app.model.BaseEntity;

@Entity
public class SensorValue extends BaseEntity {
    
    @Column
    private double value;


    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }    

}
