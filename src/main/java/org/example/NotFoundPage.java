package org.example;
public class NotFoundPage implements ContentProvider {
    @Override
    public int getStatusCode() {
        return 404;
    }

    @Override
    public String getStatusText() {
        return "Not Found";
    }

    @Override
    public String getHtmlContent() {
        return "<!DOCTYPE html><html lang=\"tr\"><head><meta charset=\"UTF-8\"></head>" +
                "<body style=\"font-family: Arial; text-align: center; margin-top: 50px;\">" +
                "<h1 style=\"color: #c53030;\">404 - Sayfa Bulunamadı</h1>" +
                "<p>Aradığınız sayfa sunucuda mevcut değil.</p>" +
                "</body></html>";
    }
}