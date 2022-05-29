package domb.app.model.events;

import domb.app.model.vehicle.Failure;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@DiscriminatorValue("REPEATING")
@SQLDelete(sql = "UPDATE events SET active = false WHERE id = ?")
@Where(clause = "active = true")
public class RepeatingFailureEvent extends Event {
    
    @Column
    private String type;
    
    @OneToMany
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
