package com.example.retrofits.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SelectiveCourses {
    private final long id;
    private final String subject; // Предмети
    private final String infoSubject; // Інформація про предмет
    private final String faculty; // Факультет
    private final String fullNameTeacher;
    private final int countStudents; // Кількість вибраних студентами предмету

    public SelectiveCourses(long id, String subject, String infoSubject, String faculty, String fullNameTeacher, int countStudents) {
        this.id = id;
        this.subject = subject;
        this.infoSubject = infoSubject;
        this.faculty = faculty;
        this.fullNameTeacher = fullNameTeacher;
        this.countStudents = countStudents;
    }

    public long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getInfoSubject() {
        return infoSubject;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getFullNameTeacher() {
        return fullNameTeacher;
    }

    public int getCountStudents() {
        return countStudents;
    }

    @Override
    public String toString() {
        return " subject='" + subject + '\'' +
                "\n faculty='" + faculty + '\'' +
                "\n fullNameTeacher='" + fullNameTeacher + '\'' +
                "\n countStudents=" + countStudents + "\n";
    }
}
