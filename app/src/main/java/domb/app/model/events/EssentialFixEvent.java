package domb.app.model.events;

import org.kie.api.definition.type.Role;


@Role(Role.Type.EVENT)
public class EssentialFixEvent extends Event {
    
    private String part;


    public EssentialFixEvent() {
    }


    public EssentialFixEvent(String part) {
        this.part = part;
    }

    public String getPart() {
        return this.part;
    }

    public void setPart(String part) {
        this.part = part;
    }
    
}
