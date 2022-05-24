package domb.sbnz.model.events;

import domb.sbnz.model.vehicle.Failure;

import java.util.List;

public class RepeatingFailureEvent extends Event {
    private String type;
    private List<Failure> relatedFailures;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Failure> getRelatedFailures() {
        return relatedFailures;
    }

    public void setRelatedFailures(List<Failure> relatedFailures) {
        this.relatedFailures = relatedFailures;
    }
}
