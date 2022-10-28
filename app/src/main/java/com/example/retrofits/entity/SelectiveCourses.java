package com.example.retrofits.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SelectiveCourses {
    @SerializedName("id")
    @Expose
    private final long id;
    @SerializedName("subject")
    @Expose
    private final String subject; // Предмети
    @SerializedName("faculty")
    @Expose
    private final String faculty; // Факультет
    @SerializedName("fullNameTeacher")
    @Expose
    private final String fullNameTeacher;
    @SerializedName("countStudents")
    @Expose
    private final int countStudents; // Кількість вибраних студентами предмету

    public SelectiveCourses(long id, String subject, String faculty, String fullNameTeacher, int countStudents) {
        this.id = id;
        this.subject = subject;
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
