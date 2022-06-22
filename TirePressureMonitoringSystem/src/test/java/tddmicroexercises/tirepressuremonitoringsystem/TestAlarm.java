package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class TestAlarm {

    @Test
    void isNotAlarmOn() {
        Alarm alarm = new Alarm();
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    void isNotAlarmOnWhenAllowedRange() {
        Alarm alarm = new MockAlarm(20);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    void isAlarmOnWhenInjectSensorInAlarm() {
        Sensor sensor = mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22.0);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    void isNotAlarmOnWhenInjectSensorInAlarm() {
        Sensor sensor = mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18.0);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    void isAlarmOn() {
        Alarm alarm = new MockAlarm(30);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
}
