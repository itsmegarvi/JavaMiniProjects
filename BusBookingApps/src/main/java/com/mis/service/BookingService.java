package com.mis.service;

import com.mis.entity.Bookings;
import com.mis.entity.Bus;
import com.mis.exception.BusNotFoundException;
import com.mis.exception.NoTicketException;
import com.mis.exception.NoTicketsAvailableException;
import com.mis.repository.BookingRepository;
import com.mis.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    BusRepository busRepository;

    @Autowired
    BusService busService;

    public List<Bus> getBuses(String source, String destination) throws BusNotFoundException {
        List<Bus> buses = busRepository.findAllBySourceAndDestination(source,destination);
        if(buses.isEmpty()){
            throw new BusNotFoundException("Bus from " + source + " to " + destination + " not found");
        }
        return buses;
    }

    public String getSeats(String busName) throws BusNotFoundException{
        Bus bus = busRepository.findByBusName(busName);
        if(bus!=null){
            int bs = bus.getSeatCount();
            int available = bs - bus.getOccupancy();
            return "For bus " + busName + " Total seat are " + bs + " and " + available + " seats are available";
        }
        else {
            throw new BusNotFoundException("Bus " + busName + " does not exists");
        }
    }

    public Bookings bookTicket(Bookings booking){
        return bookingRepository.save(booking);
    }

    public Bookings bookTicket(String busName) throws BusNotFoundException,NoTicketsAvailableException{
        Bus bus = busRepository.findByBusName(busName);
        if(bus!=null){
            if(bus.getOccupancy()<=bus.getSeatCount()/2){
                Bookings booking = new Bookings();
                int newOccupancy = bus.getOccupancy()+1;
                booking.setSeatNum(newOccupancy);
                bus.setOccupancy(newOccupancy);
                booking.setBusName(busName);
                try{
                    busService.updateBus(busName);
                }
                catch(Exception e){
                    System.out.println(e);
                }
                return bookingRepository.save(booking);
            }else{
                throw new NoTicketsAvailableException("Sorry please look for another buses");
            }
        }else{
            throw new BusNotFoundException("Bus " + busName + " does not exists");
        }
    }

    public String cancel(Long id) throws NoTicketException{
        Bookings b = bookingRepository.findByBookingId(id);
        if(b==null){
            throw new NoTicketException("No such ticket or already cancelled");
        }
        bookingRepository.delete(b);
        return "Ticket Cancelled";
    }
}
