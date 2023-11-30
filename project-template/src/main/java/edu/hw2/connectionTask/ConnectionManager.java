package edu.hw2.connectionTask;

public interface ConnectionManager {
    Connection getConnection() throws ConnectionException;
}
