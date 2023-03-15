package com.mis.jpa.controller;

import com.mis.jpa.model.Employee;
import com.mis.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping("/addemp")
    public Employee add(@RequestBody Employee emp){
        return service.addEmployee(emp);
    }

    @PostMapping(value = "/addemployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employeeList){
        return service.addEmployees(employeeList);
    }

    @GetMapping("/search/{id}")
    public Employee searchEmployee(@PathVariable("id") long id){
        return service.searchEmployee(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") long id){
        return service.deleteEmployee(id);
    }

    @GetMapping("/listall")
    public List<Employee> listEmployees(){
        return service.listAll();
    }


    @GetMapping("/searche/{email}")
    public Employee searchEmployee(@PathVariable("email") String email){
        return service.searchByEmail(email);
    }


}
