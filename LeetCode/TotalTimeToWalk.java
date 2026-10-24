package org.example.Study.LeetCode;

public class TotalTimeToWalk {

            /*
        openTime = 80
        closeTime = 40
        walkingTime = 15
        No of Gates = 3
         */


    public static int calculateTotalTime(int openTime,int closeTime,int walkingTime,int noOfGates){

        int totalTimerequired = 0;
        int duration  = openTime + closeTime;

        for(int i = 1; i < noOfGates; i++){
            totalTimerequired += walkingTime;


            int currentCycleTime = totalTimerequired % duration;

            if(currentCycleTime > openTime){
                int waitTime = duration - currentCycleTime;
                totalTimerequired += waitTime;
            }

        }
        return totalTimerequired;
    }


    public static void main(String[] args){
        //TestCase one

        int totalDuration  = calculateTotalTime(80,40,15,3);
        int totalDuration2 = calculateTotalTime(1,1,4,5);
        int totalDuration3 = calculateTotalTime(4,5,4,3);
        int totalDuration4 = calculateTotalTime(10,5,7,4);
        int totalDuration5 = calculateTotalTime(2,3,9,3);

        System.out.print("totalDuration" + totalDuration + "totalDuration2" + totalDuration2 + "totalDuration3" + totalDuration3 + "totalDuration4" + totalDuration4 + "totalDuration5" + totalDuration5);



    }
}
