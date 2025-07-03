package com.incubyte;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    // POSITIVE TEST CASES
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
    void returnsSumOfNumbersSeparatedByComma() {
        assertEquals(6, new StringCalculator().add("1,5"));
        assertEquals(10, new StringCalculator().add("1,2,3,4"));
    }

    // Step 2 - Allow any number of numbers
    @Test
    void handlesLargeSumWithoutOverflow() {
        assertEquals(2_000_000L, new StringCalculator().add("1,".repeat(2_000_000)));
    }

    // Step 3 - Allow to handle \n (new lines) between numbers
    @Test
    void allowsNewLineAsDelimiterAlongWithComma() {
        assertEquals(6, new StringCalculator().add("1\n2,3"));
    }

    // Step 4 - Support Custom Delimiter
    @Test
    void supportsCustomDelimiterDefinedInHeader(){
        assertEquals(3, new StringCalculator().add("//;\n1;2"));
    }

    // Step 5 - Throw Exception on Negative Numbers
    // Step 6 - Return the numbers if multiple negative numbers
    @Test
    void throwsExceptionOnNegativeNumbers() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new StringCalculator().add("1, -2, 3, -4"));
        assertEquals("negative numbers not allowed [-2, -4]", e.getMessage());
    }

    // Step 7 - Add getCalledCount() to check add() invocations
    @Test
    void trackAddMethodInvokedCalls() {
        StringCalculator sc = new StringCalculator();
        sc.add("1, 2");
        sc.add("3, 4");
        assertEquals(2, sc.getCalledCount());
    }

    // Step 8 skipped (.NET only)
    // Step 9 - Ignore Numbers > 1000
    @Test
    void numbersGreaterThan1000Ignored() {
        assertEquals(2, new StringCalculator().add("2,1001"));
        assertEquals(1002, new StringCalculator().add("2,1000"));
    }

    // Step 10 - Delimiters can be of any length
    @Test
    void supportsDelimiterOfAnyLength() {
        assertEquals(6, new StringCalculator().add("//[***]\n1***2***3"));
    }

    // Step 11 - Allow multiple single character delimiters
    @Test
    void supportsMultipleSingleCharDelimiters() {
        assertEquals(6, new StringCalculator().add("//[*][%]\n1*2%3"));
    }

    // Step 12 - Allow multiple delimiters of any length
    @Test
    void supportsMultipleDelimitersOfAnyLength() {
        assertEquals(6, new StringCalculator().add("//[**][%%]\n1**2%%3"));
    }
}
