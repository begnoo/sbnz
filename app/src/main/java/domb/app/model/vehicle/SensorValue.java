package domb.app.model.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import domb.app.model.BaseEntity;

@Entity
@SQLDelete(sql = "UPDATE sensor_value SET active = false WHERE id = ?")
@Where(clause = "active = true")
@Role(Role.Type.EVENT)
@Expires("10s")
public class SensorValue extends BaseEntity {
    
    @Column
    private double reading;

    @Column
    private String vehicleManufacturer;
    
    @Column
    private String vehicleModel;
    
    @Column
    private String sensorType;

    public double getReading() {
        return this.reading;
    }

    public void setReading(double reading) {
        this.reading = reading;
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

    public String getSensorType() {
        return this.sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

}
