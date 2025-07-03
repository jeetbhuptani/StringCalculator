package com.incubyte;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    @Test
    void returnsZeroOnEmptyString() {
        assertEquals(0, new StringCalculator().add(""));
    }

    @Test
    void returnsNumberForSingleInput(){
        assertEquals(5, new StringCalculator().add("5"));
    }

    @Test
    void returnsSumofNumbersSeperatedByComma() {
        assertEquals(6, new StringCalculator().add("1,5"));
        assertEquals(10, new StringCalculator().add("1,2,3,4"));
    }

}
