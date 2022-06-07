package domb.app.model.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.kie.api.definition.type.Role;

import domb.app.model.BaseEntity;

@Entity
@SQLDelete(sql = "UPDATE sensor_value SET active = false WHERE id = ?")
@Where(clause = "active = true")
@Role(Role.Type.EVENT)
public class SensorValue extends BaseEntity {
    
    @Column
    private double value;

    //promeniti da se ovo radi sa id
    @Column
    private String vehicleManufacturer;
    
    @Column
    private String vehicleModel;


    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
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


}
