package tddmicroexercises.telemetrysystem;

public class TelemetryClient {
    public static final String DIAGNOSTIC_MESSAGE = "AT#UD";

    private boolean onlineStatus;
    private String diagnosticMessageResult = "";

    private final TelemetryDataSource dataSource;

    public TelemetryClient(TelemetryRepository telemetryRepository) {
        this.dataSource = (TelemetryDataSource) telemetryRepository;
    }

    public boolean getOnlineStatus() {
        return onlineStatus;
    }

    public void connect(String telemetryServerConnectionString) {
        onlineStatus = dataSource.connect(telemetryServerConnectionString);
    }

    public void disconnect() {
        onlineStatus = dataSource.disconnect();
    }

    public void send(String message) {
        if (message == null || "".equals(message)) {
            throw new IllegalArgumentException();
        }

        if (message.equals(DIAGNOSTIC_MESSAGE)) {
            diagnosticMessageResult =
                    "LAST TX rate................ 100 MBPS\r\n"
                            + "HIGHEST TX rate............. 100 MBPS\r\n"
                            + "LAST RX rate................ 100 MBPS\r\n"
                            + "HIGHEST RX rate............. 100 MBPS\r\n"
                            + "BIT RATE.................... 100000000\r\n"
                            + "WORD LEN.................... 16\r\n"
                            + "WORD/FRAME.................. 511\r\n"
                            + "BITS/FRAME.................. 8192\r\n"
                            + "MODULATION TYPE............. PCM/FM\r\n"
                            + "TX Digital Los.............. 0.75\r\n"
                            + "RX Digital Los.............. 0.10\r\n"
                            + "BEP Test.................... -5\r\n"
                            + "Local Rtrn Count............ 00\r\n"
                            + "Remote Rtrn Count........... 00";
        }
    }

    public String receive() {
        StringBuilder message;

        if (diagnosticMessageResult == null || "".equals(diagnosticMessageResult)) {
            // simulate a received message (just for illustration - not needed for this exercise)
            message = new StringBuilder();
            int messageLength = this.dataSource.getConnectionEventsSimulator().nextInt(50) + 60;
            for (int i = messageLength; i >= 0; --i) {
                message.append((char) this.dataSource.getConnectionEventsSimulator().nextInt(40) + 86);
            }

        } else {
            message = new StringBuilder(diagnosticMessageResult);
            diagnosticMessageResult = "";
        }

        return message.toString();
    }
}

