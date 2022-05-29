package domb.app.model.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import domb.app.model.BaseEntity;

@Entity
@SQLDelete(sql = "UPDATE sensor_value SET active = false WHERE id = ?")
@Where(clause = "active = true")
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
