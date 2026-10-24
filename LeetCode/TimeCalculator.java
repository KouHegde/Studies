package org.example.Study.LeetCode;

public class TimeCalculator {
    public static void  main(String[] args){
        String input = "1?:2?";

        int hours = 0;

        String hourPattern = input.substring(0,2);
        String minPattern = input.substring(3,5);


        for(int i = 1; i < 12; i++){
            String hourString = String.format("%02d",i);

            if((hourPattern.charAt(0) == '?' || hourPattern.charAt(0) ==hourString.charAt(0))
                    && (hourPattern.charAt(1) == '?' || hourPattern.charAt(1) ==hourString.charAt(1))){
                hours++;
            }
        }
        int min =0;
        for(int i = 0; i < 60; i++){
            String minString = String.format("%02d",i);

            if((minPattern.charAt(0) == '?' || minPattern.charAt(0) == minString.charAt(0))
                    && (minPattern.charAt(1) == '?' || minPattern.charAt(1) == minString.charAt(1))){
                min++;
            }
        }

        Integer out =  hours * min;

    }
}
