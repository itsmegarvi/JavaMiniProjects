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

    public String deleteEmployee(long id){
        employeeRepository.deleteById(id);
        return "Employee deleted successfully.";
    }

    public List<Employee> listAll(){
        return employeeRepository.findAll();
    }

    public Employee searchByEmail(String email){
        return employeeRepository.findByEmail(email);
    }

    public Employee searchByEmailAndSalary(String email,Double sal){
        return employeeRepository.findByEmailAndSalary(email,sal);
    }
}
