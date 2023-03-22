package com.mis.service;

import com.mis.entity.CurrencyConversion;
import com.mis.repository.CurrencyConverterRepiository;
import com.mis.vo.ExchangeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.NoSuchElementException;

@Service
public class CurrencyConversionService {

    @Autowired
    CurrencyConverterRepiository repository;

    @Autowired
    RestTemplate restTemplate;

    public String converted(Long id,Double amt) throws NoSuchElementException {
        CurrencyConversion cc = repository.findById(id).orElseThrow();
        ExchangeValue ev = restTemplate.getForObject("http://forex-service/exchange/get/" +
                cc.getCurrencyFrom() + "/" + cc.getCurrencyTo(), ExchangeValue.class);
        assert ev != null;
        double amount = amt*ev.getConversionMultiple();
        return "Your money after conversion is " + amount;
    }

    public CurrencyConversion addConversion(CurrencyConversion cv){
        return repository.save(cv);
    }


}
