package com.mis.service;

import com.mis.entity.ExchangeValue;
import com.mis.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ExchangeValueService {
    @Autowired
    ExchangeValueRepository repository;
    public ExchangeValue getExchangeValue(String from,String to){ //Might insert exception handling later
        return repository.findByCurrencyFromAndCurrencyTo(from,to);
    }
    public ExchangeValue addExchangeValue(ExchangeValue ev){
        return repository.save(ev);
    }
    public ExchangeValue update(Long id,Double cm) throws NoSuchElementException {
        ExchangeValue ev = repository.findById(id).orElseThrow();
        ev.setConversionMultiple(cm);
        return repository.save(ev);
    }
}