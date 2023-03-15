package com.mis.jpa.service;

import com.mis.jpa.model.Employee;
import com.mis.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired(required=true)
    EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        System.out.println("Saved");
        return employeeRepository.save(employee);
    }
}
