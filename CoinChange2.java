package org.example.Study.LeetCode;

public class CoinChange2 {
    private static int recur(int[] nums, int i, int target) {
        if(i == 0){
            if(target % nums[i] == 0 ) return 1;
            else return 0;
        }

        int notPick = recur(nums,i-1,target);
        int pick = 0;
        if(nums[i] <= target) pick = recur(nums,i, target-nums[i]);

        return pick+notPick;
    }


    private static int dpSol(int[] nums,int target) {
        int n = nums.length;
        int[][] dp = new int[n][target+1];

        for(int t = 0; t < target; t++){
            if(t%nums[0] == 0) dp[0][t]=1;
            else dp[0][t] = 0;
        }

        for(int i = 1; i <n; i++){
            for(int t = 0; t<= target; t++){
                int notPick = dp[i-1][t];
                int pick = 0;
                if(nums[i]<=t) pick= dp[i][t-nums[i]];
                dp[i][t] = pick+notPick;
            }
        }
        return dp[n-1][target];
    }
}
