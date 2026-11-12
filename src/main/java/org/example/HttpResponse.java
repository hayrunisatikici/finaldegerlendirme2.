package org.example;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HttpResponse {
    public void send(OutputStream out, ContentProvider provider) throws Exception {
        byte[] bodyBytes = provider.getHtmlContent().getBytes(StandardCharsets.UTF_8);

        // HTTP/1.1 protokolüne uygun header satırları
        String headers = "HTTP/1.1 " + provider.getStatusCode() + " " + provider.getStatusText() + "\r\n" +
                "Content-Type: text/html; charset=UTF-8\r\n" +
                "Content-Length: " + bodyBytes.length + "\r\n" +
                "Connection: close\r\n" +
                "\r\n";

        out.write(headers.getBytes(StandardCharsets.UTF_8));
        out.write(bodyBytes);
        out.flush();
    }
}