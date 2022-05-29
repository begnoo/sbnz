package domb.app.model.events;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@DiscriminatorValue("MAJOR")
@SQLDelete(sql = "UPDATE events SET active = false WHERE id = ?")
@Where(clause = "active = true")
public class MajorFailureEvent extends Event {
    
    @Column
    private String type;
    
    @ManyToMany
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
