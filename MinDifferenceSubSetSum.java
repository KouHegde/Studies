package org.example.Study.LeetCode;

public class MinDifferenceSubSetSum {
    public static int minDiff(int[] nums) {

        int n = nums.length;

        int target = 0;

        for (int i = 0; i < n; i++) {
            target += nums[i];
        }

        boolean[] taregtArray = targetDp(target, nums);

        int min = 0;
        for (int i = 1; i <= target/2; i++) {
            if (taregtArray[i]) {
                min = Math.min(target - 2*i, min);
            }
        }
        return min;
    }


    private static boolean[] targetDp(int target, int[] nums) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][target+1];

        for(int i = 0 ; i < n; i++){
            dp[i][0] = true;
        }

        if(nums[0] <= target) dp[0][nums[0]] = true;

        for(int i = 1; i < n ; i++) {
            for(int t= 1; t <= target; t++) {
                boolean notTake = dp[i-1][t];
                boolean take = false;
                if(t>=nums[i]) take = dp[i-1][t-nums[i]];
                dp[i][t] = take||notTake;
            }
        }
        return dp[n-1];
    }

}
