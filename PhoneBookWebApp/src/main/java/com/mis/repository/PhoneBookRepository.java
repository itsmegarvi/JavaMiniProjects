package com.mis.repository;

import com.mis.entity.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBook,Long> {

}
