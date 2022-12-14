package com.in28minutes.unittesting.unittesting.business.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class AssertJTest {

    @Test
    public void learning(){
        List<Integer> numbers = Arrays.asList(12,15,45);

        //assertThat(number, hasSize(3));
        assertThat(numbers).hasSize(3)
                .contains(12,15)
                .allMatch(x -> x > 10)
                .allMatch(x -> x < 100)
                .noneMatch(x -> x < 0);

        assertThat("").isEmpty();

        assertThat("ABCDE").contains("BCD")
                .startsWith("ABC")
                .endsWith("CDE");
    }
}
