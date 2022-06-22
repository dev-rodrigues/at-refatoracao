package tddmicroexercises.telemetrysystem;

public class TelemetryClientMock extends TelemetryClient {
    int sendCount;
    int reciveCount;

    public TelemetryClientMock(TelemetryRepository telemetryRepository) {
        super(telemetryRepository);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendCount++;
    }

    @Override
    public String receive() {
        reciveCount++;
        return super.receive();
    }
}
