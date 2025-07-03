package com.incubyte;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private int callCount = 0;

    public int add(String numbers){
        // Increment Call Count
        callCount++;

        // Step 1.1 - Return 0 for Empty Values
        if(numbers.isEmpty()) return 0;

        // Step 1.2 - Return number for given string with Single Number
        // Step 1.3 - Return sum of comma separate values
        // Step 3 - Allowed \n values
        // Step 4 - Allowed Custom Delimiters
        String delimiter = ",|\n";
        if(numbers.startsWith("//")){
            int newlineIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, newlineIndex);
            numbers = numbers.substring(newlineIndex + 1);
        }

        String[] parts = numbers.split(delimiter);
        int sum = 0;
        // Step 5 - Throw Exception on Negative values and return if more than one
        List<Integer> negatives = new ArrayList<>();

        for(String part: parts){
            // Collect negative values
            int num = Integer.parseInt(part.trim());
            if(num < 0) negatives.add(num);
            sum += num;
        }

        if(!negatives.isEmpty()){
            throw new IllegalArgumentException("negative numbers not allowed "+negatives.toString());
        }
        return sum;
    }

    public int getCalledCount() {
        return callCount;
    }
}
