package org.example;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private final int port;
    private final Router router;

    public WebServer(int port, Router router) {
        this.port = port;
        this.router = router;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Web sunucusu " + port + " portunda başlatıldı...");
            System.out.println("Tarayıcıdan erişmek için: http://localhost:" + port);

            while (true) {
                // Yeni bir tarayıcı bağlantısı gelene kadar burada bekler
                Socket clientSocket = serverSocket.accept();

                // Her bağlantı için yeni bir iş parçacığı (Thread) başlatıyoruz
                ClientHandler handler = new ClientHandler(clientSocket, router);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            System.err.println("Sunucu başlatılamadı (Port kullanımda olabilir): " + e.getMessage());
        }
    }
}