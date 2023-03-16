package com.mis.controller;

import com.mis.entity.Address;
import com.mis.entity.Student;
import com.mis.exception.InvalidStudentIDException;
import com.mis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return service.addStudent(student);
    }

    @PostMapping("/modify_address/{id}")
    public Student modifyAddress(@PathVariable("id") long id, @RequestBody List<Address> addresses) throws InvalidStudentIDException {
        return service.modifyAddress(id, addresses);
    }

    @GetMapping(name = "/get_addresses/{id}")
    public List<Address> getAddresses(@PathVariable("id") Long id){
        return service.getAddresses(id);
    }
}
