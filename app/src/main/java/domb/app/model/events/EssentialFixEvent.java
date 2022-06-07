package domb.app.model.events;

import org.kie.api.definition.type.Role;

import domb.app.model.enums.PartEnum;

@Role(Role.Type.EVENT)
public class EssentialFixEvent extends Event {
    
    private PartEnum part;


    public EssentialFixEvent() {
    }


    public EssentialFixEvent(PartEnum part) {
        this.part = part;
    }

    public PartEnum getPart() {
        return this.part;
    }

    public void setPart(PartEnum part) {
        this.part = part;
    }
    
}
