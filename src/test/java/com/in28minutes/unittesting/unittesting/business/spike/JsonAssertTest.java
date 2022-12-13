package com.in28minutes.unittesting.unittesting.business.spike;

import org.json.*;
import org.junit.jupiter.api.*;
import org.skyscreamer.jsonassert.*;

public class JsonAssertTest {

    String actualResponse =
            "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssert_StrictFalse_ExactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id:1, name:Ball, price:10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
