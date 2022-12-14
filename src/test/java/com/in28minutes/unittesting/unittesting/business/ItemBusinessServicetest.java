package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.model.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ItemBusinessServicetest {

    @InjectMocks
    private ItemBusinessServices business;
    @Mock
    private ItemRepository repository;

    @Test
    public void  calculateSumUsingDataService_basic() {
        when(repository.findAll()).thenReturn(Arrays.asList(new Item(2, "Item2", 10,10),
                new Item(3, "Item3",20,20)));
        List<Item> items = business.retrieveAllItems();

        assertEquals(100,items.get(0).getValue());
        assertEquals(400,items.get(1).getValue());
    }

}
