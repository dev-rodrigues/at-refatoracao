package tddmicroexercises.tirepressuremonitoringsystem;

public class MockAlarm extends Alarm {
    private double value;

    public MockAlarm(double value) {
        this.value = value;
    }

    @Override
    public double getPressure() {
        return value;
    }
}
