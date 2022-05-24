package domb.sbnz.model.events;

public class ExtremeAverageEvent extends Event {
    private double offsetFromAverage;

    public double getOffsetFromAverage() {
        return offsetFromAverage;
    }

    public void setOffsetFromAverage(double offsetFromAverage) {
        this.offsetFromAverage = offsetFromAverage;
    }
}
