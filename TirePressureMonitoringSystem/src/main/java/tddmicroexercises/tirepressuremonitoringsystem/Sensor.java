package tddmicroexercises.tirepressuremonitoringsystem;

import java.util.Random;

public class Sensor {
    public static final double OFFSET = 16;
    private static final Random RANDOM = new Random();

    public double popNextPressurePsiValue() {
        return OFFSET + samplePressure();
    }

    private static double samplePressure() {
        Random basicRandomNumbersGenerator = RANDOM;
        return 6 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble();
    }
}
