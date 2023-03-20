package com.mis.service;

import com.mis.repository.BookingRepository;
import com.mis.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    BusRepository busRepository;
}
