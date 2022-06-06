package domb.app.model.events;

import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
public class ExtremeAverageWarningEvent extends Event {
    
    private double offsetFromAverage;

    public double getOffsetFromAverage() {
        return offsetFromAverage;
    }

    public void setOffsetFromAverage(double offsetFromAverage) {
        this.offsetFromAverage = offsetFromAverage;
    }
}
