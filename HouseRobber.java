package org.example.Study.LeetCode;

public class HouseRobber {



    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;

            int[] dp = new int[n + 1];


            int prev = nums[0];
            int prev2 = 0;

            for (int i = 1; i < n; i++) {
                int pick = nums[i];
                if (i > 1) pick = nums[i] + prev2;

                int drop = 0 + prev;

                int curr = Math.max(pick, drop);
                prev2 = prev;
                prev = curr;

            }
            return prev;
        }

        // public int helper(int[] nums, int idx,int[] dp){

        //     if(idx == 0) return nums[0];
        //     if(idx < 0) return 0;

        //     if(dp[idx] != 0) return dp[idx];


        //     int pick = nums[idx] + helper(nums, idx-2,dp);
        //     int drop = 0 + helper(nums, idx-1,dp);

        //     return dp[idx] = Math.max(pick,drop);

        // }

    }

    public int rob2(int[] nums){
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++){
            int pick = nums[i] + dp[i-2];
            int drop = dp[i-1];
            dp[i] = Math.max(pick, drop);
        }
        return dp[n-1];
    }

}
