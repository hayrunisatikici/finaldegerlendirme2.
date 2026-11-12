package org.example;
public class Router {
    private final ContentProvider homePage;
    private final ContentProvider notFoundPage;

    public Router(ContentProvider homePage, ContentProvider notFoundPage) {
        this.homePage = homePage;
        this.notFoundPage = notFoundPage;
    }

    public ContentProvider route(HttpRequest request) {
        // Sadece ana dizine ("/") gelen isteklerde biyografi sayfasını döndür
        if ("/".equals(request.getPath())) {
            return homePage;
        }
        return notFoundPage;
    }
}