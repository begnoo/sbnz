package domb.app.model.events;

import org.kie.api.definition.type.Role;

import domb.app.model.enums.ExtremeType;

@Role(Role.Type.EVENT)
public class ExtremeAverageWarningEvent extends Event {
    
    private double offsetFromAverage;
    private ExtremeType type;


    public ExtremeAverageWarningEvent() {
    }

    public ExtremeAverageWarningEvent(double offsetFromAverage, ExtremeType type) {
        this.offsetFromAverage = offsetFromAverage;
        this.type = type;
    }

    public double getOffsetFromAverage() {
        return offsetFromAverage;
    }

    public void setOffsetFromAverage(double offsetFromAverage) {
        this.offsetFromAverage = offsetFromAverage;
    }

    public ExtremeType getType() {
        return this.type;
    }

    public void setType(ExtremeType type) {
        this.type = type;
    }

}
