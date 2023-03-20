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

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

//    public Contact addNumberContact(Contact c){
//        for(PhoneNumbers i: c.getPhoneNums()){
//            i.setContact(c);
//        }
//        return c;
//    }

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

    public List<Contact> searchByName(String name) throws ContactNotFoundException {
        List<Contact> c =  contactRepository.findAllByName(name);
        if(c.isEmpty()){
            logger.error("Name not in database");
            throw new ContactNotFoundException("Contact not found");
        }
        return c;
    }

    public Contact searchByNumber(String number) throws ContactNotFoundException{
        List<PhoneNumbers> n = phoneNumbersRepository.findByPhoneNumber(number);
        if(n==null){
            throw new ContactNotFoundException("Cannot find number "+number);
        }
         return n.get(0).getContact();
    }

    public List<Contact> searchForName(String s) throws ContactNotFoundException{
       try {
           List<Contact> contacts = contactRepository.findAllByNameContains(s);
           return contacts.stream().sorted(Comparator.comparing(Contact::getName)).toList();
       } catch (Exception e){
           throw new ContactNotFoundException("Noone named " + s + " is here");
       }
    }

    public List<Contact> searchByEmail(String email) throws ContactNotFoundException {
        try {
            return contactRepository.findAllByEmails(email);
        } catch (Exception e) {
            throw new ContactNotFoundException("Email you searched for doesn't exists");
        }
    }

    public List<Contact> searchEmail(String email) throws ContactNotFoundException{
        try{
            List<Contact> contacts = contactRepository.findAllByEmails(email);
            return contacts.stream().sorted(Comparator.comparing(Contact::getName)).toList();
        }
        catch (Exception e){
            throw new ContactNotFoundException("Email " + email + " you searched for does not exist");
        }
    }



}
