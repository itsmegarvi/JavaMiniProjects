package com.mis.repository;

import com.mis.entity.CurrencyConversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyConverterRepiository extends JpaRepository<CurrencyConversion,Long> {

}
