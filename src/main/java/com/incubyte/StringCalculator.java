package com.incubyte;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            String delimiterPart = numbers.substring(2, newlineIndex);
            numbers = numbers.substring(newlineIndex + 1);

            if(delimiterPart.startsWith("[") && delimiterPart.endsWith("]")){
                List<String> delimiters = new ArrayList<>();
                Matcher m = Pattern.compile("\\[(.*?)]").matcher(delimiterPart);
                while(m.find())
                    delimiters.add(Pattern.quote(m.group(1)));
                delimiter = String.join("|", delimiters);
            } else {
                delimiter = Pattern.quote(delimiterPart);
                System.out.println(delimiterPart);
            }
        }

        String[] parts = numbers.split(delimiter);
        int sum = 0;
        // Step 5 - Throw Exception on Negative values and return if more than one
        List<Integer> negatives = new ArrayList<>();

        for(String part: parts){
            // Collect negative values
            int num = Integer.parseInt(part.trim());
            if(num < 0) negatives.add(num);
            // Step 9 - Ignore numbers greater than 1000
            if(num <= 1000)
                sum += num;
        }

        if(!negatives.isEmpty()){
            throw new IllegalArgumentException("negative numbers not allowed "+negatives.toString());
        }
        return sum;
    }

    // Step 7 - To return the count of add() method invocations
    public int getCalledCount() {
        return callCount;
    }
}
