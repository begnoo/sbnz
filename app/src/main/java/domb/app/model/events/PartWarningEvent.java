package domb.app.model.events;

import org.kie.api.definition.type.Role;

import domb.app.model.enums.PartEnum;

@Role(Role.Type.EVENT)
public class PartWarningEvent extends Event {
    
    private PartEnum part;

    public PartWarningEvent() {
    }

    public PartWarningEvent(PartEnum part) {
        this.part = part;
    }

    public PartEnum getPart() {
        return this.part;
    }

    public void setPart(PartEnum part) {
        this.part = part;
    }
    
}
