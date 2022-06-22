package tddmicroexercises.tirepressuremonitoringsystem;

public class BagOfSecurity {
    private  final double lowPressureThreshold;
    private final double highPressureThreshold;

    public BagOfSecurity(double lowPressureThreshold,  double highPressureThreshold) {
        this.highPressureThreshold = highPressureThreshold;
        this.lowPressureThreshold = lowPressureThreshold;
    }

    public boolean includeInRangeValue(double value) {
        return this.lowPressureThreshold <= value && value <= highPressureThreshold;
    }
}
