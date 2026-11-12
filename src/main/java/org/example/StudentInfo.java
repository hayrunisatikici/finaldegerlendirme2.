package org.example;
public class StudentInfo {
    private final String fullName;
    private final String studentNumber;
    private final String biography;

    public StudentInfo(String fullName, String studentNumber, String biography) {
        this.fullName = fullName;
        this.studentNumber = studentNumber;
        this.biography = biography;
    }

    public String getFullName() {
        return fullName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getBiography() {
        return biography;
    }
}