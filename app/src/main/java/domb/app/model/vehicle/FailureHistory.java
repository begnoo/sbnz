package domb.app.model.vehicle;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import domb.app.model.BaseEntity;

@Entity
@SQLDelete(sql = "UPDATE failure_history SET active = false WHERE id = ?")
@Where(clause = "active = true")
public class FailureHistory extends BaseEntity {

    @OneToMany
    private List<Failure> failures;

    public List<Failure> getFailures() {
        return failures;
    }

    public void setFailures(List<Failure> failures) {
        this.failures = failures;
    }
}
