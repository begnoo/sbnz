package domb.app.model.events;

import domb.app.model.vehicle.Failure;

import java.util.List;

import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
public class EssentialFixEvent extends Event {
    
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
