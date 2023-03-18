package com.mis.repository;

import com.mis.entity.PhoneNumbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumbersRepository extends JpaRepository<PhoneNumbers,Long> {

}
