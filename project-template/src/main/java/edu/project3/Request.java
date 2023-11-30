package edu.project3;

public class Request {
    private final String method;
    private final String url;
    private final String file;
    private final String prtl;

    private Request(String request) {
        String[] parts = request.split(" ");
        method = parts[0];
        url = parts[1];
        prtl = parts[2];
        parts = url.split("/");
        file = parts[parts.length - 1];
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getFile() {
        return file;
    }

    public String getProtocol() {
        return prtl;
    }

    public static Request parse(String request) {
        return new Request(request);
    }
}
