package com.incubyte;

public class StringCalculator {
    public int add(String numbers){

        //Step 1.1 - Return 0 for Empty Values
        if(numbers.isEmpty()) return 0;

        //Step 1.2 - Return number for given string with Single Number
        //Step 1.3 - Return sum of comma separate values
        String[] parts = numbers.split(",");
        int sum = 0;
        for(String part: parts){
            sum += Integer.parseInt(part);
        }
        return sum;
    }
}
