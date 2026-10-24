package org.example.Study.LeetCode;

public class DevidePeopleIntoTeams {
    public static int devide(int p, int t){
        int[][] dp = new int[t+1][p+1];

        for(int i = 1; i <= t; i++){
            for(int j = 1; j<= p; j++){
                if(j < i){
                    dp[i][j] = 0;
                } else if(j==i){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1]*i;
                }

            }
        }
        return dp[p][t];
    }
}
