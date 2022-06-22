package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static tddmicroexercises.telemetrysystem.TestUtils.getTelemetryMock;

class TelemetryDiagnosticControlsTest {

    @Test
    void checkSendAndReciveDiagnostic() throws Exception {
        TelemetryDataSource dataSource = new TelemetryDataSource();
        TelemetryClientMock mock = new TelemetryClientMock(dataSource);
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(mock);
        telemetryDiagnosticControls.checkTransmission();
        Assertions.assertEquals(1, mock.reciveCount);
        Assertions.assertEquals(1, mock.sendCount);
    }

    @Test
    void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls();
        telemetryDiagnosticControls.checkTransmission();
        String expected = getTelemetryMock();
        Assertions.assertEquals(expected, telemetryDiagnosticControls.getDiagnosticInfo());
    }
}
