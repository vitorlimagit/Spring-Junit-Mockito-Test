package com.in28minutes.unittesting.unittesting.controller;


import com.in28minutes.unittesting.unittesting.business.*;
import com.in28minutes.unittesting.unittesting.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessServices itemBusinessServices;

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService(){
        return itemBusinessServices.retreiveHardcodedItem();
    }
}
