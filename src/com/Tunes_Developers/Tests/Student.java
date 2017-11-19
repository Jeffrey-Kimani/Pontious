package com.Tunes_Developers.Tests;

/**
 * Created by Geoffrey-Kimani on 11/19/2017.
 */
public class Student {
    private int id;
    private String name;
    private String email;
    private String adm_no;
    private int marks;

    public Student(int id, String name, String email, String adm_no, int marks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.adm_no = adm_no;
        this.marks = marks;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAdmissionNumber() {
        return adm_no;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", adm_no='" + adm_no + '\'' +
                ", marks=" + marks +
                '}';
    }
}
