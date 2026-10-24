package org.example.Study.LeetCode;

public class ClimbingStairs {

    public int climb(int stairs){
        if(stairs<=2){
            return stairs;
        }
        int[] dp = new int[stairs+1];

        dp[1] =  1;
        dp[2] = 2;

        for(int i = 3; i <= stairs; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[stairs];
    }
}
