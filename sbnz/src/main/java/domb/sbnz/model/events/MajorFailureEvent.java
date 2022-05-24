package domb.sbnz.model.events;

import domb.sbnz.model.vehicle.Failure;

import java.util.List;

public class MajorFailureEvent extends Event {
    private String type;
    private List<Event> relatedEvents;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Event> getRelatedEvents() {
        return relatedEvents;
    }

    public void setRelatedEvents(List<Event> relatedEvents) {
        this.relatedEvents = relatedEvents;
    }
}
