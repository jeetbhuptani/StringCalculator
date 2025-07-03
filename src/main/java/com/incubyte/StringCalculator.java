package com.incubyte;

public class StringCalculator {
    public int add(String numbers){

        //Step 1.1 - Return 0 for Empty Values
        if(numbers.isEmpty()) return 0;

        //Step 1.2 - Return number for Given String with Single Number
        return Integer.parseInt(numbers);
    }
}
