package com.mis.controller;

import com.mis.entity.Contact;
import com.mis.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PB")
public class ContactController {

    @Autowired
    ContactService service;

    Logger logger = LoggerFactory.getLogger(ContactController.class);

    @GetMapping("/hi")
    public String hello(){
        return "lets get to work";
    }

    @GetMapping("getAll")
    public List<Contact> getAll(){
        return service.getAll();
    }

    @PostMapping("/add")
    public Contact add(@RequestBody Contact c){
        return service.addContact(c);
    }

    @DeleteMapping("/delete/{id}")
    public String del(@PathVariable("id") Long id){
        return service.deleteContact(id);
    }


}
