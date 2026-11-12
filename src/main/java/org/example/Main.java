package org.example;

public class Main {
    public static void main(String[] args) {
        // 1. Öğrenci bilgilerini ve doğal biyografi metnini tanımla
        StudentInfo student = new StudentInfo(
                "Hayrunisa Tikici",
                "1250505061",
                "Adım Hayrunisa Tikici, 20 yaşındayım ve Bursalıyım. " +
                        "Kırklareli Üniversitesi Yazılım Mühendisliği 2. sınıf öğrencisiyim. " +
                        "Üniversiteye kadar Bursa'da yaşadım, şimdi eğitimim için Kırklareli'ndeyim. " +
                        "Bölümde Java, C ve veri yapıları gibi temel derslerle yazılımın mutfağını öğrenmeye çalışıyorum. " +
                        "Teorik derslerden çok, bilgisayarın başına geçip kendi kodumu yazarak bir şeyler denemek bana daha çok şey katıyor.<br><br>" +
                        "Dersler dışında kitap okumayı, dizi izlemeyi ve kafa dağıtmak için sudoku çözmeyi seviyorum. " +
                        "Kendi hızımda öğrenmeyi seven, merak ettiği konuları araştıran biriyim. " +
                        "Şu an ekranda görünen bu sayfa, hiçbir hazır kütüphane kullanmadan Java Socket yapısıyla kurduğum basit web sunucusu üzerinden çalışıyor.");

        // 2. Sayfa sağlayıcılarını oluştur (Liskov Substitution)
        ContentProvider homePage = new BiographyPage(student);
        ContentProvider notFoundPage = new NotFoundPage();

        // 3. Yönlendiriciyi (Router) yapılandır
        Router router = new Router(homePage, notFoundPage);

        // 4. Sunucuyu 1989 portunda başlat
        WebServer server = new WebServer(1989, router);
        server.start();
    }
}