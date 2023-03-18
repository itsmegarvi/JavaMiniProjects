package com.mis.controller;

import com.mis.service.PhoneBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PB")
public class PhoneBookController {

    @Autowired
    PhoneBookService service;

    Logger logger = LoggerFactory.getLogger(PhoneBookController.class);

    @GetMapping("/hi")
    public String hello(){
        return "lets get to work";
    }



}
