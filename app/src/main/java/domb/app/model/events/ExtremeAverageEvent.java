package domb.app.model.events;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@DiscriminatorValue("EXTREME")
@SQLDelete(sql = "UPDATE events SET active = false WHERE id = ?")
@Where(clause = "active = true")
public class ExtremeAverageEvent extends Event {
    
    @Column
    private double offsetFromAverage;

    public double getOffsetFromAverage() {
        return offsetFromAverage;
    }

    public void setOffsetFromAverage(double offsetFromAverage) {
        this.offsetFromAverage = offsetFromAverage;
    }
}
