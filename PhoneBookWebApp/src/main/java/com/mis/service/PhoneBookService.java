package com.mis.service;

import com.mis.controller.PhoneBookController;
import com.mis.repository.PhoneBookRepository;
import com.mis.repository.PhoneNumbersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneBookService {
    @Autowired
    PhoneBookRepository phoneBookRepository;

    @Autowired
    PhoneNumbersRepository phoneNumbersRepository;

    Logger logger = LoggerFactory.getLogger(PhoneBookService.class);

}
