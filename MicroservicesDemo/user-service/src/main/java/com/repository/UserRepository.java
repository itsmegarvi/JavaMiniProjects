package com.repository;

import com.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByUserId(Long id);

    List<Users> findAllByDepartmentId(Long deptId);

    Users findByEmailId(String email);
}
