package com.mis.controller;

import com.mis.entity.CurrencyConversion;
import com.mis.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/converter")
public class CurrencyConversionController {
    @Autowired
    CurrencyConversionService service;

    @GetMapping("/convert/{id}/{amt}")
    public String convert(@PathVariable("id") Long id, @PathVariable("amt") Double amt){
        return service.converted(id,amt);
    }

    @PostMapping("/add")
    public CurrencyConversion add(@RequestBody CurrencyConversion cv){
        return service.addConversion(cv);
    }
}
