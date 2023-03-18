package com.mis.service;

import com.mis.entity.Contact;
import com.mis.repository.ContactRepository;
import com.mis.repository.PhoneNumbersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    @Autowired
    PhoneNumbersRepository phoneNumbersRepository;

    Logger logger = LoggerFactory.getLogger(ContactService.class);

    public List<Contact> getAll(){
        return contactRepository.findAll();
    }

    public Contact addContact(Contact c){
        return contactRepository.save(c);
    }

    public String deleteContact(Long id){
        Contact c = contactRepository.findByPersonId(id);
        contactRepository.delete(c);
        return "Contact deleted successfully";
    }


}
