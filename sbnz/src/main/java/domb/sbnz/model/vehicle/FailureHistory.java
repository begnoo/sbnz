package domb.sbnz.model.vehicle;

import java.util.List;

public class FailureHistory {
    private List<Failure> failures;

    public List<Failure> getFailures() {
        return failures;
    }

    public void setFailures(List<Failure> failures) {
        this.failures = failures;
    }
}
