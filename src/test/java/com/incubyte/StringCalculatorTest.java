package com.incubyte;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    @Test
    void returnsZeroOnEmptyString() {
        assertEquals(0, new StringCalculator().add(""));
        assertEquals(5, new StringCalculator().add("5"));
    }
}
