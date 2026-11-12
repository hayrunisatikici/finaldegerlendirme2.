package org.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final Router router;

    public ClientHandler(Socket clientSocket, Router router) {
        this.clientSocket = clientSocket;
        this.router = router;
    }

    @Override
    public void run() {
        // try-with-resources yapısı ile işlem bitince soket ve akışlar otomatik kapatılır
        try (Socket socket = this.clientSocket;
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             OutputStream out = socket.getOutputStream()) {

            // İsteğin ilk satırını oku (Örn: GET / HTTP/1.1)
            String requestLine = in.readLine();
            if (requestLine == null || requestLine.isEmpty()) {
                return;
            }

            HttpRequest request = new HttpRequest(requestLine);
            ContentProvider page = router.route(request);

            HttpResponse response = new HttpResponse();
            response.send(out, page);

        } catch (Exception e) {
            System.err.println("İstemci isteği işlenirken hata oluştu: " + e.getMessage());
        }
    }
}