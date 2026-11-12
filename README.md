# Java Socket Tabanlı Basit Web Sunucusu

Bu proje, hiçbir 3. parti kütüphane veya harici çerçeve (framework) kullanılmadan, yalnızca standart Java (`java.net` ve `java.io`) kütüphaneleri ile geliştirilmiş basit bir HTTP web sunucusudur.
Sunucu, **1989** portu üzerinden gelen istemci isteklerini dinler ve tarayıcıya HTML/CSS ile biçimlendirilmiş öğrenci biyografi sayfasını yanıt olarak döndürür.

## Proje Özellikleri
* **Saf Java Mimarisi:** `ServerSocket` ve `Socket` sınıfları kullanılarak TCP/IP tabanlı istemci-sunucu iletişimi kurulmuştur.
* **Çoklu İş Parçacığı (Multi-Threading):** Gelen her tarayıcı isteği `ClientHandler` sınıfı aracılığıyla ayrı bir `Thread` üzerinde işlenir. Bu sayede eşzamanlı bağlantılarda sunucunun kilitlenmesi önlenir.
* **Dinamik HTTP Yanıtları:** İstemciden gelen `GET` istekleri ayrıştırılarak uygun HTTP durum kodları (`200 OK` veya `404 Not Found`) ve `UTF-8` destekli HTML içerikleri üretilir.
* **SOLID Prensipleri:** Kodun okunabilirliğini ve genişletilebilirliğini artırmak amacıyla sorumluluklar ayrı sınıflara bölünmüştür.

## Proje Yapısı ve Sınıf Sorumlulukları

* **`Main.java`:** Uygulamanın başlangıç noktasıdır. Bağımlılıkları oluşturur ve sunucuyu `1989` portunda başlatır.
* **`WebServer.java`:** Belirlenen portu (`1989`) dinler ve kabul edilen her bağlantıyı yeni bir iş parçacığına devreder.
* **`ClientHandler.java`:** İstemci soketinden gelen veriyi okur, yönlendiriciye iletir ve oluşan yanıtı istemciye gönderir.
* **`HttpRequest.java`:** Tarayıcıdan gelen ham HTTP istek satırını (metot ve URL yolu) ayrıştırır.
* **`HttpResponse.java`:** Standart HTTP/1.1 yanıt başlıklarını (`Content-Type`, `Content-Length`) ve HTML gövdesini oluşturur.
* **`Router.java`:** Gelen URL yoluna (`/`) göre hangi sayfa sağlayıcısının çalışacağına karar verir.
* **`ContentProvider.java`:** Sayfa içeriklerini standartlaştırmak için kullanılan arayüzdür (Interface).
* **`BiographyPage.java`:** Öğrenci bilgilerini ve biyografiyi HTML/CSS formatında oluşturan ana sayfadır.
* **`NotFoundPage.java`:** Tanımsız URL istekleri (örneğin `/favicon.ico`) için `404` hata sayfası üretir.
* **`StudentInfo.java`:** Öğrencinin ad-soyad, numara ve biyografi verilerini tutan model sınıfıdır.

## Kurulum ve Çalıştırma

1. Projeyi bilgisayarınıza klonlayın:
   ```bash
   git clone [https://github.com/KULLANICI_ADINIZ/REPO_ADINIZ.git](https://github.com/KULLANICI_ADINIZ/REPO_ADINIZ.git)
Projeyi IntelliJ IDEA veya herhangi bir Java IDE'si ile açın.
