package org.example.Study.LeetCode;

import java.net.Inet4Address;

public class BestWayToScheduleJobWithMaxDifficulty {
    class Solution {
        public int minDifficulty(int[] jobDifficulty, int d) {

            Integer[][] dp = new Integer[jobDifficulty.length][d+1];

            return dfs(0,d,jobDifficulty,dp) == Integer.MAX_VALUE ? -1 : dfs(0,d,jobDifficulty,dp);

        }

        public int dfs(int index, int remainingDays, int[] jobDifficulty,Integer[][] dp ){

            if(dp[index][remainingDays] != null) return dp[index][remainingDays];

            int max = Integer.MIN_VALUE;
            if(remainingDays == 1){
                for(int i = index; i < jobDifficulty.length; i++){
                    max = Math.max(jobDifficulty[i],max);
                }
                return dp[index][1] = max;
            }

            int answer = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            for(int i = index; i <= jobDifficulty.length- remainingDays; i++ ){
                max = Math.max(max,jobDifficulty[i]);
                answer = Math.min(max + dfs(i+1,remainingDays-1,jobDifficulty,dp),answer);
            }
            return dp[index][remainingDays] = answer;
        }
    }


    public static int sumOfLocalMinima(int[] jobDiff, int days){

        Integer[][] dp = new Integer[jobDiff.length][days+1];
        return dfs(0, jobDiff,days,dp);
    }

    private static int dfs(int index, int[] jobDiff, int days, Integer[][] dp) {
        if(dp[index][days] != null) return dp[index][days];

        int max = 0;
        if(days == 1){
            for(int i= index; i < jobDiff.length; i++){
                max = Math.max(jobDiff[i],max);
            }
            return max;
        }

        int ans = Integer.MAX_VALUE;
        max = 0;
        for(int i = index; i <= jobDiff.length; i++){
            max = Math.max(jobDiff[i],max);

            ans = Math.min(ans,max + dfs(i+1,jobDiff,days-1,dp));
        }
        return dp[index][days] = ans;
    }
}
