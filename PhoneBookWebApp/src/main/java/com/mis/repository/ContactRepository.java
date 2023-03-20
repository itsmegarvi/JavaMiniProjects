package com.mis.repository;

import com.mis.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {

    public Contact findByPersonId(Long id);

    public Contact findByName(String str);

//    public Contact findByPhoneNums();
}
