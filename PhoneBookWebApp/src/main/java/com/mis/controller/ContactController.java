package com.mis.controller;

import com.mis.entity.Contact;
import com.mis.exception.ContactNotFoundException;
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

    @PutMapping("/update/{id}")
    public Contact update(@PathVariable("id") Long id, @RequestBody String s) throws ContactNotFoundException {
        return service.update(id,s);
    }

    @GetMapping("/nameSearch")
    public List<Contact> searchByName(@RequestBody String name) throws ContactNotFoundException {
        return service.searchByName(name);
    }

    @GetMapping("/phoneNumSearch")
    public Contact searchByPhoneNumber(@RequestBody String phonNum) throws ContactNotFoundException{
        return service.searchByNumber(phonNum);
    }

    @GetMapping("/emailSearch")
    public List<Contact> emailSearch(@RequestBody String email) throws ContactNotFoundException{
        return service.searchByEmail(email);
    }

    @GetMapping("/nameContaining")
    public List<Contact> searchForName(@RequestBody String name) throws ContactNotFoundException{
        return service.searchForName(name);
    }

    @GetMapping("/emailContaining")
    public List<Contact> emailContaining(@RequestBody String str) throws ContactNotFoundException{
        return service.emailsContaining(str);
    }
}
