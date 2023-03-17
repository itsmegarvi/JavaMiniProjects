package com.service;

import com.entity.Department;
import com.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public Department addDepartment(Department d){
        return departmentRepository.save(d);
    }

    public Department searchById(long l){
        return departmentRepository.findById(l).orElseThrow(null);
    }

    public Department updateById(Long id, String s){
        Department d = departmentRepository.findByDepartmentId(id);
        d.setDepartmentName(s);
        return departmentRepository.save(d);
    }
}
