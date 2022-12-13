package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class ItemBusinessServices {


    public Item retreiveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }
}
