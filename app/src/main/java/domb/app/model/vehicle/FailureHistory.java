package domb.app.model.vehicle;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import domb.app.model.BaseEntity;

@Entity
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
