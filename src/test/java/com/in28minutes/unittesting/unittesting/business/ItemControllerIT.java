package com.in28minutes.unittesting.unittesting.business;


import com.in28minutes.unittesting.unittesting.model.*;
import org.json.*;
import org.junit.jupiter.api.*;
import org.skyscreamer.jsonassert.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.boot.test.web.client.*;


@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws JSONException {
        String response = this.restTemplate.getForObject("/all-items-from-database", String.class);
        JSONAssert.assertEquals("[{id:10001}, {id:10002}, {id:10003}]", response, false);
    }

}
