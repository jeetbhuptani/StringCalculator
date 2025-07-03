package com.incubyte;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    // Step 1.1 Empty String
    @Test
    void returnsZeroOnEmptyString() {
        assertEquals(0, new StringCalculator().add(""));
    }

    // Step 1.2 Single Integer Value
    @Test
    void returnsNumberForSingleInput(){
        assertEquals(5, new StringCalculator().add("5"));
    }

    // Step 1.3 Comma separated values
    @Test
    void returnsSumofNumbersSeperatedByComma() {
        assertEquals(6, new StringCalculator().add("1,5"));
        assertEquals(10, new StringCalculator().add("1,2,3,4"));
    }

    // Step 2 - Allow any amount of numbers
    @Test
    void handlesLargeSumWithoutOverflow() {
        StringBuilder input = new StringBuilder();
        for(int i = 0; i< 2_000_000; i++)
            input.append("1,");
        input.append("1");
        assertEquals(2_000_001L, new StringCalculator().add(input.toString()));
    }

    // Step 3 - Allow to handle \n (new lines) between numbers
    @Test
    void allowsNewLineAsDelimiterAlongWithComma() {
        assertEquals(6, new StringCalculator().add("1\n2,3"));
        // ',' and '\n' possible next to next causing empty string
        assertEquals(10, new StringCalculator().add("1,\n2,3,4"));
        assertEquals(10, new StringCalculator().add("1,\n2,3\n4"));
    }
}
