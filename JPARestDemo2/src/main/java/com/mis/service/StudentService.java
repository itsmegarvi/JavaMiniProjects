package com.mis.service;

import com.mis.entity.Laptop;
import com.mis.entity.Student;
import com.mis.repository.LaptopRepository;
import com.mis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    LaptopRepository laptopRepository;

    public Student addStudent(Student s){
        System.out.println("Saved");
        return studentRepository.save(s);
    }

    public List<Student> listAllStud(){
        return studentRepository.findAll();
    }

    public List<Laptop> listAlLap(){
        return laptopRepository.findAll();
    }

    public String getStudent(long id){
        return studentRepository.findById(id).get().toString();
    }

}
