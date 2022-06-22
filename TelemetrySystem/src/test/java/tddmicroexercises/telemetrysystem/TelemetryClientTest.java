package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TelemetryClientTest {

    @Test
    void shouldBeCreateConnection() {
        TelemetryDataSource dataSource = new TelemetryDataSource();
        TelemetryClient client = new TelemetryClient(dataSource);
        client.connect("dummy");
        Assertions.assertTrue(client.getOnlineStatus());
    }

    @Test
    void shouldNotBeCreateConnection() {
        TelemetryDataSource dataSource = new TelemetryDataSource();
        TelemetryClient client = new TelemetryClient(dataSource);
        Assertions.assertThrows(IllegalArgumentException.class, () -> client.connect(""));
    }
}