package com.mis.repository;

import com.mis.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {


    @Query("SELECT a FROM Address a WHERE a.student.studentId = ?1")
    List<Address> findByStudentId(Long studentId);

}
