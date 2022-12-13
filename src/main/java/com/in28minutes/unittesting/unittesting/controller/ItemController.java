package com.in28minutes.unittesting.unittesting.controller;


import com.in28minutes.unittesting.unittesting.model.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1, "Ball", 10, 100);
    }

}
