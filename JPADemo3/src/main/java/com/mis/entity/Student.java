package com.mis.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

    @Entity
    public class Student{

        @Id
        private long studentId;
        private String name;
        private String college;

        @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
        List<Address> address = new ArrayList<>();;

        public Student(long studentId, String name, String college, List<Address> address) {
            this.studentId = studentId;
            this.name = name;
            this.college = college;
            this.address = address;
        }

        public Student(){

        }

        public List<Address> getAddress() {
            return address;
        }

        public long getStudentId() {
            return studentId;
        }

        public void setStudentId() {
            this.studentId = studentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
        }

        public void setAddress(List<Address> address) {
            this.address = address;
        }
    }
