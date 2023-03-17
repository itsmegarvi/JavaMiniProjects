package com.controller;

import com.entity.Department;
import com.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
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

    @PutMapping("/update/{id}/{name}")
    public Department update(@PathVariable("id") Long id, @PathVariable("name") String name){
        return service.updateById(id,name);
    }



}
