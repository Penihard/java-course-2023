package edu.hw2.connectionTask;

public class DefaultConnectionManager implements ConnectionManager {
    @Override
    @SuppressWarnings("MagicNumber")
    public Connection getConnection() {
        if (Math.random() > 0.5) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}
