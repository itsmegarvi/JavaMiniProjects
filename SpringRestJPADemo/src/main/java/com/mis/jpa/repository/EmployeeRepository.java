package com.mis.jpa.repository;

import com.mis.jpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("select u from Employee u where u.email = ?1")
    public Employee findByEmail(String email);

    @Query("select x from Employee x where x.email=?1 and x.salary>?2")
    public Employee findByEmailAndSalary(String s,double d);
}