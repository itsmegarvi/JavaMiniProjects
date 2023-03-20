package com.mis.controller;

import com.mis.entity.Bookings;
import com.mis.entity.Bus;
import com.mis.exception.BusNotFoundException;
import com.mis.exception.NoTicketException;
import com.mis.exception.NoTicketsAvailableException;
import com.mis.service.BusService;
import com.mis.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class BookingController {
    @Autowired
    BookingService bookingService ;
    @Autowired
    BusService busService;

    @GetMapping("/buses/{source}/{destination}")
    public List<Bus> getBuses(@PathVariable("source") String source, @PathVariable("destination") String destination) throws BusNotFoundException {
        return bookingService.getBuses(source,destination);
    }

    @GetMapping("/seats")
    public String getSeats(@RequestBody String busName) throws BusNotFoundException{
        return bookingService.getSeats(busName);
    }

    @PostMapping("/book")
    public Bookings bookTicket(@RequestBody String busName) throws BusNotFoundException, NoTicketsAvailableException {
        return bookingService.bookTicket(busName);
    }

    @DeleteMapping("/cancel")
    public String cancel(@RequestBody Long id) throws NoTicketException {
        return bookingService.cancel(id);
    }

}
