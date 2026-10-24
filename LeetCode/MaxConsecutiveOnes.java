package org.example.Study.LeetCode;

public class MaxConsecutiveOnes {

    public static int[] calculate(String sorted){

        int left = 0;
        int[] ansIndex = new int[2];

        int max = 0;

        for(int right = 0; right < sorted.length(); right++){
            if(sorted.charAt(left) != sorted.charAt(right)){
                left = right;
            } else{
                if(max < right-left +1 &&  right-left +1 > 1){
                    max = right -left+1;
                    ansIndex[0] = left;
                    ansIndex[1] = right;
                }
            }
        }
        return ansIndex;
    }
}
