package org.example;
public class HttpRequest {
    private final String method;
    private final String path;

    public HttpRequest(String requestLine) {
        // Örnek gelen satır: "GET / HTTP/1.1"
        if (requestLine != null && !requestLine.isEmpty()) {
            String[] parts = requestLine.split(" ");
            this.method = parts.length > 0 ? parts[0] : "GET";
            this.path = parts.length > 1 ? parts[1] : "/";
        } else {
            this.method = "GET";
            this.path = "/";
        }
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }
}