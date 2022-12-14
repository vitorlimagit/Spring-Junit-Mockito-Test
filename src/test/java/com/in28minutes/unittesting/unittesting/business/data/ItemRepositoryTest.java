package com.in28minutes.unittesting.unittesting.business.data;


import com.in28minutes.unittesting.unittesting.model.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;
    @Test
    public void testFindAll(){
        List<Item> items = repository.findAll();
        assertEquals(3, items.size());
    }
}
