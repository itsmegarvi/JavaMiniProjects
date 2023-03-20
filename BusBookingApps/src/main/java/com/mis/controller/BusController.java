package com.mis.controller;

import com.mis.entity.Bus;
import com.mis.exception.BusNotFoundException;
import com.mis.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class BusController {


    @Autowired
    BusService service;
    @RequestMapping("/")
    public String hello(){
        return "hi";
    }

    @PostMapping("/add")
    public Bus add(@RequestBody Bus bus){
        return service.addBus(bus);
    }

    @GetMapping("/get")
    public List<Bus> getAll(){
        return service.getBus();
    }

    @DeleteMapping("/del")
    public String delete(@RequestBody String busName) throws BusNotFoundException {
        return service.deleteBus(busName);
    }

    @PutMapping("/update")
    public Bus update(@RequestBody String busName ) throws BusNotFoundException{
        return service.updateBus(busName);
    }


}
