package org.example.Study.LeetCode;

public class MinimumNumberOfCoinsDP {
    static final int INF = (int) 1e9;

    public static int coins(int[] nums, int target){
        int n = nums.length;
        return recur(nums,n-1,target);
    }

    private static int recur(int[] nums, int i, int target) {
        if(i == 0){
            if(target % nums[i] == 0 ) return target/nums[i];
            else return INF;
        }

        int notPick = recur(nums,i-1,target);
        int pick = INF;
        if(nums[i] <= target) pick =1+recur(nums,i, target-nums[i]);

        return Math.min(pick,notPick);
    }

    private static int recur(int[] nums, int i, int target, int[][]dp) {
        if(dp[i][target] != -1) return dp[i][target];
        if(i == 0){
            if(target % nums[i] == 0 ) return target/nums[i];
            else return INF;
        }

        int notPick = recur(nums,i-1,target,dp);
        int pick = INF;
        if(nums[i] <= target) pick = 1 + recur(nums,i, target-nums[i],dp);

        return dp[i][target] = Math.min(pick,notPick);
    }

    public static  int tabulation(int[] nums, int target){
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        dp[0][0] = 0;
        for(int j = 0 ; j <= target; j++) {
            if (j % nums[0] == 0) {
                dp[0][j] = j / nums[0];
            } else {
                dp[0][j] = INF;
            }
        }

        for(int i = 1; i < n; i++){
            for(int t = 0; t<=target; t++){
                int notPick = dp[i-1][t];
                int pick = INF;
                if(nums[i]<=t) pick = 1+dp[i][t-nums[i]];
                dp[i][t] =Math.min(pick,notPick);
            }

        }
        return dp[n-1][target];
    }
}
