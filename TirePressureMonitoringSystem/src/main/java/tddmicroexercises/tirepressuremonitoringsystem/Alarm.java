package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double HIGH_PRESSURE_THRESHOLD = 21;

    private Sensor sensor;
    private boolean alarmOn;
    private BagOfSecurity bagOfSecurity = new BagOfSecurity(LOW_PRESSURE_THRESHOLD, HIGH_PRESSURE_THRESHOLD);

    private void init(Sensor sensor, BagOfSecurity bagOfSecurity) {
        this.sensor = sensor;
        this.alarmOn = false;
        this.bagOfSecurity = bagOfSecurity;
    }

    public Alarm(Sensor sensor) {
        init(sensor, new BagOfSecurity(LOW_PRESSURE_THRESHOLD, HIGH_PRESSURE_THRESHOLD));
    }

    public Alarm() {
        init(new Sensor(), new BagOfSecurity(LOW_PRESSURE_THRESHOLD, HIGH_PRESSURE_THRESHOLD));
    }

    public void check() {
        double psiPressureValue = getPressure();

        if (isNotSecurity(psiPressureValue)) {
            alarmOn = true;
        }
    }

    private boolean isNotSecurity(double psiPressureValue) {
        return !bagOfSecurity.includeInRangeValue(psiPressureValue);
    }

    public double getPressure() {
        return sensor.popNextPressurePsiValue();
    }
    public boolean isAlarmOn() {
        return alarmOn;
    }
}
