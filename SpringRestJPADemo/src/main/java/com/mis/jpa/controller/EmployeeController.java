package com.mis.jpa.controller;

import com.mis.jpa.model.Employee;
import com.mis.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping(value = "/addemp")
    public Employee add(@RequestBody Employee emp){
        return service.addEmployee(emp);
    }
}
