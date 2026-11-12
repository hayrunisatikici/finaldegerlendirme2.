package org.example;
public interface ContentProvider {
    int getStatusCode();
    String getStatusText();
    String getHtmlContent();
}