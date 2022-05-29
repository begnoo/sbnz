package domb.app.model.vehicle;

import domb.app.model.BaseEntity;
import domb.app.model.enums.SensorType;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@SQLDelete(sql = "UPDATE sensor SET active = false WHERE id = ?")
@Where(clause = "active = true")
public class Sensor extends BaseEntity {
    
    @Column
    private SensorType type;
    
    @Column
    private double normalAvgValue;
    
    @Column
    private String measuringUnit;
    
    @Column
    @OneToMany
    private List<SensorValue> values;

    public SensorType getType() {
        return type;
    }

    public void setType(SensorType type) {
        this.type = type;
    }

    public double getNormalAvgValue() {
        return normalAvgValue;
    }

    public void setNormalAvgValue(double normalAvgValue) {
        this.normalAvgValue = normalAvgValue;
    }

    public String getMeasuringUnit() {
        return measuringUnit;
    }

    public void setMeasuringUnit(String measuringUnit) {
        this.measuringUnit = measuringUnit;
    }

    public List<SensorValue> getValues() {
        return this.values;
    }

    public void setValues(List<SensorValue> values) {
        this.values = values;
    }

}
