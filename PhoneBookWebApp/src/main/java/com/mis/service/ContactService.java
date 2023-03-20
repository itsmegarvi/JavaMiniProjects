package com.mis.service;

import com.mis.entity.Contact;
import com.mis.entity.PhoneNumbers;
import com.mis.exception.ContactNotFoundException;
import com.mis.exception.InvalidPersonIdException;
import com.mis.repository.ContactRepository;
import com.mis.repository.PhoneNumbersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    public Contact updateContact(Long id,String email) throws InvalidPersonIdException {

        Contact c = contactRepository.findByPersonId(id);
        if(c!=null){
        c.setEmails(email);
        return c;}else{
            throw new InvalidPersonIdException("This person doesn't exists");
        }
    }

    public Contact searchByName(String name) throws ContactNotFoundException {
        Contact c =  contactRepository.findByName(name);
        if(c==null){
            logger.error("Name not in database");
            throw new ContactNotFoundException("Contact not found");
        }
        return c;
    }

//    public Contact seaarchByNumber(String number) throws ContactNotFoundException{
//        List<PhoneNumbers> s = phoneNumbersRepository.findByPhoneNumber(number);
//        if(s.isEmpty()){
//            throw new ContactNotFoundException("Cannot find number "+number);
//        }
//        return s.get(0).getContact
//    }


}
