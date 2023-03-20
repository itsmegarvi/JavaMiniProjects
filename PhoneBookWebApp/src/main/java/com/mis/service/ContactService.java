package com.mis.service;

import com.mis.entity.Contact;
import com.mis.entity.Email;
import com.mis.entity.PhoneNumbers;
import com.mis.exception.ContactNotFoundException;
import com.mis.repository.ContactRepository;
import com.mis.repository.EmailRepository;
import com.mis.repository.PhoneNumbersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    PhoneNumbersRepository phoneNumbersRepository;

    Logger logger = LoggerFactory.getLogger(ContactService.class);

    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    public Contact addContact(Contact c) {
        return contactRepository.save(c);

    }


    public String deleteContact(Long id) {
        Contact c = contactRepository.findByPersonId(id);
        contactRepository.delete(c);
        return "Contact deleted successfully";
    }

    public List<Contact> searchByName(String name) throws ContactNotFoundException {
        List<Contact> c = contactRepository.findAllByName(name);
        if (c.isEmpty()) {
            logger.error("Name not in database");
            throw new ContactNotFoundException("Contact not found");
        }
        return c;
    }

    public Contact searchByNumber(String number) throws ContactNotFoundException {
        List<PhoneNumbers> n = phoneNumbersRepository.findByPhoneNumber(number);
        if (n == null) {
            throw new ContactNotFoundException("Cannot find number " + number);
        }
        return n.get(0).getContact();
    }

    public List<Contact> searchByEmail(String email) throws ContactNotFoundException {
        List<Email> emails = emailRepository.findAllByEmail(email);
        if (emails.isEmpty()) {
            throw new ContactNotFoundException("Contact with email ID " + email + " not found");
        }
        List<Contact> contacts = new ArrayList<>();
        emails.forEach(x -> contacts.add(x.getContact()));
        return contacts.stream().sorted(Comparator.comparing(Contact::getName)).toList();
    }

    public List<Contact> searchForName(String s) throws ContactNotFoundException {
        try {
            List<Contact> contacts = contactRepository.findAllByNameContains(s);
            return contacts.stream().sorted(Comparator.comparing(Contact::getName)).toList();
        } catch (Exception e) {
            throw new ContactNotFoundException("Noone named " + s + " is here");
        }
    }

    public List<Contact> emailsContaining(String str) throws ContactNotFoundException {
        List<Email> emails = emailRepository.findAllByEmailContains(str);
        if (emails.isEmpty()) {
            throw new ContactNotFoundException("Contact with email ID containing " + str + " not found");
        }
        List<Contact> contacts = new ArrayList<>();
        emails.forEach(x -> contacts.add(x.getContact()));
        return contacts.stream().sorted(Comparator.comparing(Contact::getName)).toList();
    }

    public Contact update(Long id, String name) throws ContactNotFoundException {
        Contact contact = contactRepository.findByPersonId(id);
        if (contact == null) {
            throw new ContactNotFoundException("No contact of ID: " + id);
        }
        contact.setName(name);
        return contactRepository.save(contact);
    }
}
