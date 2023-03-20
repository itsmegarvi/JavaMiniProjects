package com.mis.service;

import com.mis.entity.Item;
import com.mis.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public Item add(Item i){
        return itemRepository.save(i);
    }

    public List<Item> getAll(){
        return itemRepository.findAll();
    }
}
