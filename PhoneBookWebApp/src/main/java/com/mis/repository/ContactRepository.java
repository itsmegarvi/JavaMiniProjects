package com.mis.repository;

import com.mis.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {

    public Contact findByPersonId(Long id);

    public List<Contact> findAllByName(String str);

    public List<Contact> findAllByNameContains(String str);
}
