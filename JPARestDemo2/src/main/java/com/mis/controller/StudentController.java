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

    @PostMapping("/addlap")
    public Laptop add(@RequestBody Laptop l){
        return service.addLaptop(l);
    }

    @PostMapping("/add")
    public String add(@RequestBody Student s, Laptop l){
        return service.addStudAndLap(s,l);
    }

    @GetMapping("/listallstud")
    public List<Student> listAllStud(){
        return service.listAllStud();
    }

    @GetMapping("/listalllap")
    public List<Laptop> listAllLap(){
        return service.listAlLap();
    }

//    @GetMapping("/listall"){
//        public List<>
//    }

    @GetMapping("/getstud/{id}")
    public String getStud(@PathVariable("id") long id){
        return service.getStudent(id);
    }
}
