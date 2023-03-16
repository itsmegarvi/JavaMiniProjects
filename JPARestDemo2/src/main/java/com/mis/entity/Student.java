package com.mis.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    private long studentID;
    private String name;
    private String about;

//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "laptop",referencedColumnName ="laptopID" )
    private Laptop laptop;

    public Student(long studentID, String name, String about, Laptop laptop) {
        this.studentID = studentID;
        this.name = name;
        this.about = about;
        this.laptop = laptop;
    }

    public Student(){

    }

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", name='" + name + '\'' +
                ", about='" + about + '\''+
                '}';
    }
}
