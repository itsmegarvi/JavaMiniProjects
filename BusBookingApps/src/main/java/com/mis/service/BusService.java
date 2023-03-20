package com.mis.service;

import com.mis.entity.Bus;
import com.mis.exception.BusNotFoundException;
import com.mis.repository.BookingRepository;
import com.mis.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {
    @Autowired
    BusRepository busRepository;

    public Bus addBus(Bus bus){
        return busRepository.save(bus);
    }

    public List<Bus> getBus(){
        return busRepository.findAll();
    }

    public String deleteBus(String busName) throws BusNotFoundException {
        Bus b = busRepository.findByBusName(busName);
        if(b==null){
            throw new BusNotFoundException("Bus with bus name: " + busName + " not found");
        }
        busRepository.delete(b);
        return "Deleted successfully";
    }

    public Bus updateBus(String busName) throws BusNotFoundException{
        Bus b = busRepository.findByBusName(busName);
        if(b==null){
            throw new BusNotFoundException("Bus with busName " + busName + " does not exists");
        }
        int s = b.getOccupancy();
        s++;
        b.setOccupancy(s);
        return busRepository.save(b);
    }


}
