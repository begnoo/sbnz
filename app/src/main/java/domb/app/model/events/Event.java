package domb.app.model.events;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import domb.app.model.BaseEntity;
import domb.app.model.enums.EventClass;
@Entity
@Table(name = "events")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "eventClass", discriminatorType = DiscriminatorType.STRING)
@Where(clause = "active = true")
public class Event extends BaseEntity {

    @Enumerated(EnumType.STRING)
	@Column(name = "eventClass", insertable = false, updatable = false)
    private EventClass eventClass;

    public EventClass getEventClass() {
        return this.eventClass;
    }

    public void setEventClass(EventClass eventClass) {
        this.eventClass = eventClass;
    }

}
