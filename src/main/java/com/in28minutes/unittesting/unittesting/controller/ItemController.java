package com.in28minutes.unittesting.unittesting.controller;


import com.in28minutes.unittesting.unittesting.business.*;
import com.in28minutes.unittesting.unittesting.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessServices businessServices;

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService(){
        return businessServices.retreiveHardcodedItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> retrieveAllItems(){
        return businessServices.retrieveAllItems();
    }

}
