package domb.sbnz.model.vehicle;

import domb.sbnz.model.BaseEntity;
import domb.sbnz.model.enums.SensorType;

import java.util.List;

public class Sensor extends BaseEntity {
    private SensorType type;
    private double normalAvgValue;
    private String measuringUnit;
    private List<Double> values;

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

    public List<Double> getValues() {
        return values;
    }

    public void setValues(List<Double> values) {
        this.values = values;
    }
}
