package edu.hw2.connectionTask;

public class ConnectionException extends RuntimeException {
    public ConnectionException(String mess) {
        super(mess);
    }

    public ConnectionException(String mes, Throwable cause) {
        super(mes, cause);
    }

}
