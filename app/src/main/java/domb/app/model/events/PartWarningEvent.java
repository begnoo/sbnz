package domb.app.model.events;

import java.util.List;

import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
public class PartWarningEvent extends Event {
    
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
