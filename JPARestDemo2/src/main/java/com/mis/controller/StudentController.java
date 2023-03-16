package com.mis.controller;

import com.mis.entity.Laptop;
import com.mis.entity.Student;
import com.mis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping("/addstud")
    public Student add(@RequestBody Student s){
        return service.addStudent(s);
    }


    @GetMapping("/listallstud")
    public List<Student> listAllStud(){
        return service.listAllStud();
    }

    @GetMapping("/listalllap")
    public List<Laptop> listAllLap(){
        return service.listAlLap();
    }


    @GetMapping("/getstud/{id}")
    public String getStud(@PathVariable("id") long id){
        return service.getStudent(id);
    }
}
