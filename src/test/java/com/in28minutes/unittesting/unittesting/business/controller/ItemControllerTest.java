package com.in28minutes.unittesting.unittesting.business.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.in28minutes.unittesting.unittesting.business.*;
import com.in28minutes.unittesting.unittesting.controller.*;
import com.in28minutes.unittesting.unittesting.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.*;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessServices businessServices;

    @Test
    public void dummyItem_basic() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();
        //JSONAssert.assertEquals(expected, actual, false);
    }

    @Test
    public void itemFromBusinessService_basic() throws Exception {

        when(businessServices.retreiveHardcodedItem()).thenReturn(
                new Item(2, "Item2", 10,10));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2, name:Item2, price:10}"))
                .andReturn();
        //JSONAssert.assertEquals(expected, actual, false);
    }

    @Test
    public void retrieveAllItems_basic() throws Exception {

        when(businessServices.retrieveAllItems()).thenReturn(
                Arrays.asList(new Item(2, "Item2", 10,10),
                new Item(3, "Item3", 20,20))
                );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:2, name:Item2, price:10}," +
                        "{}]"))
                .andReturn();
        //JSONAssert.assertEquals(expected, actual, false);
    }


}