package com.mis.jpa.service;

import com.mis.jpa.model.Employee;
import com.mis.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired(required=true)
    EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        System.out.println("Saved");
        return employeeRepository.save(employee);
    }

    public List<Employee> addEmployees(List<Employee> employeeList ){
        System.out.println("Employees added");
        return employeeRepository.saveAll(employeeList);
    }

    public Employee searchEmployee(Long id){
        return employeeRepository.findById(id).orElse(null);
    }
}
