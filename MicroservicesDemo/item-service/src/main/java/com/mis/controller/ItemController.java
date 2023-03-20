package com.mis.controller;

import com.mis.entity.Item;
import com.mis.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    ItemService service;

    @GetMapping("/getall")
    public List<Item> get(){
        return service.getAll();
    }

    @PostMapping("/add")
    public Item add(@RequestBody Item i){
        return service.add(i);
    }
}
