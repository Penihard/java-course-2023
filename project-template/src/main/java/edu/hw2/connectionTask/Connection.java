package edu.hw2.connectionTask;

public interface Connection extends AutoCloseable {
    void execute(String command);

    void close();

    void open();
}
