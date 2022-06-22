package tddmicroexercises.telemetrysystem;

import java.util.Random;

public class TelemetryDataSource implements TelemetryRepository{

    private final Random connectionEventsSimulator = new Random(42);

    @Override
    public Random getConnectionEventsSimulator() {
        return connectionEventsSimulator;
    }
    @Override
    public boolean connect(String telemetryServerConnectionString) {
        if (telemetryServerConnectionString == null ||  telemetryServerConnectionString.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return connectionEventsSimulator.nextInt(10) <= 8;
    }

    @Override
    public boolean disconnect() {
        return false;
    }
}
