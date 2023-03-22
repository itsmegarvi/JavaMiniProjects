package com.mis.controller;

import com.mis.entity.ExchangeValue;
import com.mis.exception.InvalidIDException;
import com.mis.service.ExchangeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exchange")
public class ExchangeValueController {
    @Autowired
    ExchangeValueService service;

    @GetMapping("/get/{from}/{to}")
    public ExchangeValue get(@PathVariable("from") String from, @PathVariable("to") String to){
        return service.getExchangeValue(from,to);
    }

    @PostMapping("/add")
    public ExchangeValue add(@RequestBody ExchangeValue ev){
        return service.addExchangeValue(ev);
    }

    @PutMapping("/update/{id}/{conversionMultiple}")
    public ExchangeValue update(@PathVariable("id") Long id,@PathVariable("conversionMultiple") Double cm)
    throws InvalidIDException{
            return service.update(id,cm);
    }
}