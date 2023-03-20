package com.mis.repository;

import com.mis.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {

    public Contact findByPersonId(Long id);

    public List<Contact> findAllByName(String str);

    public List<Contact> findAllByNameContains(String str);

    public List<Contact> findAllByEmails(String email);

//    @Query("select u from Contact  where u.email=?1 and order by u.name")
//    public List<Contact> findByEmailsOrderByName(String s);


//    public Contact findByPhoneNums();
}
