package tddmicroexercises.telemetrysystem;

import java.util.Random;

public interface TelemetryRepository {
    Random getConnectionEventsSimulator();
    boolean connect(String telemetryServerConnectionString);
    boolean disconnect();
}
