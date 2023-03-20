package com.mis.repository;

import com.mis.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email,Long> {
    public List<Email> findAllByEmail(String email);

    public List<Email> findAllByEmailContains(String str);
}
