
package org.example;

public class BiographyPage implements ContentProvider {
    private final StudentInfo student;

    public BiographyPage(StudentInfo student) {
        this.student = student;
    }

    @Override
    public int getStatusCode() {
        return 200;
    }

    @Override
    public String getStatusText() {
        return "OK";
    }

    @Override
    public String getHtmlContent() {
        return "<!DOCTYPE html>" +
                "<html lang=\"tr\">" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<title>" + student.getFullName() + " - Biyografi</title>" +
                "<style>" +
                "body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f4f6f9; color: #2d3748; margin: 0; padding: 40px; }" +
                ".container { max-width: 750px; margin: auto; background: #ffffff; padding: 40px; border-radius: 12px; box-shadow: 0 6px 15px rgba(0,0,0,0.08); }" +
                "h1 { color: #1a365d; font-size: 34px; margin: 0 0 8px 0; border-bottom: 3px solid #2b6cb0; padding-bottom: 10px; }" +
                "h2 { color: #2b6cb0; font-size: 20px; font-weight: 600; margin: 10px 0 20px 0; }" +
                ".info-grid { display: flex; flex-wrap: wrap; gap: 10px; margin-bottom: 22px; }" +
                ".badge { background-color: #ebf8ff; color: #2c5282; padding: 6px 14px; border-radius: 20px; font-size: 14px; font-weight: 500; border: 1px solid #bee3f8; }" +
                ".bio-box { background-color: #f8fafc; padding: 25px; border-left: 5px solid #2b6cb0; border-radius: 6px; }" +
                "p { font-family: Georgia, serif; font-size: 16px; line-height: 1.8; color: #1a202c; margin: 0; text-align: justify; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class=\"container\">" +
                "<h1>" + student.getFullName() + "</h1>" +
                "<h2>Öğrenci No: " + student.getStudentNumber() + "</h2>" +
                "<div class=\"info-grid\">" +
                "<span class=\"badge\">Yaş: 20</span>" +
                "<span class=\"badge\">Memleket: Bursa</span>" +
                "<span class=\"badge\">Kırklareli Üniversitesi - Yazılım Mühendisliği</span>" +
                "</div>" +
                "<div class=\"bio-box\">" +
                "<p>" + student.getBiography() + "</p>" +
                "</div>" +
                "</div>" +
                "</body>" +
                "</html>";
    }
}