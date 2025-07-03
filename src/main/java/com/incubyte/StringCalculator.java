package com.incubyte;

public class StringCalculator {
    public int add(String numbers){

        // Step 1.1 - Return 0 for Empty Values
        if(numbers.isEmpty()) return 0;

        // Step 1.2 - Return number for given string with Single Number
        // Step 1.3 - Return sum of comma separate values
        // Step 3 - Allowed \n values
        // Step 4 - Allowed Delimiters
        String delimiter = ",|\n";
        if(numbers.startsWith("//")){
            int newlineIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, newlineIndex);
            numbers = numbers.substring(newlineIndex + 1);
        }

        String[] parts = numbers.split(delimiter);
        int sum = 0;
        for(String part: parts){
            // Solution - for: ',' and '\n' possible next to next causing empty("") string
            if(part.trim().isEmpty()) continue;
            sum += Integer.parseInt(part);
        }
        return sum;
    }
}
