package com.mis.repository;

import com.mis.entity.PhoneNumbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneNumbersRepository extends JpaRepository<PhoneNumbers,Long> {

    public List<PhoneNumbers> findByPhoneNumber(String number);
}
