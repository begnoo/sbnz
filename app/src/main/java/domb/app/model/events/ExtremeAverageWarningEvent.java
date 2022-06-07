package domb.app.model.events;

import org.kie.api.definition.type.Role;

import domb.app.model.enums.ExtremeType;

@Role(Role.Type.EVENT)
public class ExtremeAverageWarningEvent extends Event {
    
    private double offsetFromAverage;
    private ExtremeType extremeType;
    private String sensorType;


    public ExtremeAverageWarningEvent() {
    }


    public ExtremeAverageWarningEvent(double offsetFromAverage, ExtremeType extremeType, String sensorType) {
        this.offsetFromAverage = offsetFromAverage;
        this.extremeType = extremeType;
        this.sensorType = sensorType;
    }
    

    public double getOffsetFromAverage() {
        return offsetFromAverage;
    }

    public void setOffsetFromAverage(double offsetFromAverage) {
        this.offsetFromAverage = offsetFromAverage;
    }

    public ExtremeType getExtremeType() {
        return this.extremeType;
    }

    public void setExtremeType(ExtremeType extremeType) {
        this.extremeType = extremeType;
    }

    public String getSensorType() {
        return this.sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }


}
