package com.controller;

import com.entity.Department;
import com.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @PostMapping("/add")
    public Department add(@RequestBody Department d){
        return service.addDepartment(d);
    }

    @GetMapping("/getbyid/{id}")
    public Department getById(@PathVariable("id") long id){
        return service.searchById(id);
    }

}
