package domb.app.model.events;

import org.kie.api.definition.type.Role;

import domb.app.model.enums.ExtremeType;

@Role(Role.Type.EVENT)
public class ExtremeAverageWarningEvent extends Event {
    
    private double offsetFromAverage;
    private ExtremeType type;

    public double getOffsetFromAverage() {
        return offsetFromAverage;
    }

    public void setOffsetFromAverage(double offsetFromAverage) {
        this.offsetFromAverage = offsetFromAverage;
    }
}
