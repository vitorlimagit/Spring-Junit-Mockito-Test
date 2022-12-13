package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class ItemBusinessServices {

    @Autowired
    private ItemRepository repository;

    public Item retreiveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }

    public List<Item> retrieveAllItems(){

        List<Item> items = repository.findAll();
        for(Item item:items){
            item.setValue(item.getPrice() * item.getQuantity());
        }

        return repository.findAll();
    }
}
