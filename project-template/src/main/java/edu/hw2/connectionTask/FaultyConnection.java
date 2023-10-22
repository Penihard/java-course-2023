package edu.hw2.connectionTask;

import java.util.logging.Logger;

public class FaultyConnection implements Connection {
    static boolean isClosed;
    private final Logger faultyConnectionLogger = Logger.getLogger("FAULTY_CONNECTION");

    @Override
    @SuppressWarnings("MagicNumber")
    public void execute(String command) {
        open();
        if (Math.random() > 0.5) {
            close();
            throw new ConnectionException("Faulty Connection Error");
        } else {
            faultyConnectionLogger.info("Executing command: " + command);
            close();
        }
    }

    public void open() {
        faultyConnectionLogger.info("Open connection");
        isClosed = false;
    }

    @Override
    public void close() {
        faultyConnectionLogger.info("Close connection");
        isClosed = true;
    }
}
