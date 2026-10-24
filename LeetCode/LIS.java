package org.example.Study.LeetCode;

import java.util.Arrays;

public class LIS {


    public static void main(String[] args){
        int[] nums = new int[] {0,1,0,3,2,3};
        oneD(nums);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for(int i = n-1; i >= 0; i--){
            for(int j = i-1; j>= -1; j--){
                int np =dp[i+1][j+1];
                int pick = Integer.MIN_VALUE;
                if(j == -1 || nums[i] > nums[j]) pick = 1 +dp[i+1][i+1];
                dp[i][j+1] = Math.max(pick , np);
            }
        }
        return dp[0][0];

    }

    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n+1][n+1];
            for(int[] d : dp){
                Arrays.fill(d,-1);
            }
            return calcuclate(0, -1, nums, dp);

        }

        public int calcuclate(int i, int prev, int[]nums,int[][] dp){
            if(i > nums.length-1) return 0;
            if(dp[i+1][prev+1] != -1) return dp[i+1][prev+1];
            int notPick = calcuclate(i+1,prev,nums, dp);
            int pick = Integer.MIN_VALUE;
            if(prev == -1  || nums[i] > nums[prev]) pick = 1 + calcuclate(i+1,i,nums,dp);

            return dp[i+1][prev+1] = Math.max(notPick,pick);
        }
    }

    public static int oneD(int[] nums){
        int n = nums.length;

        int[]dp = new int[n+1];

        Arrays.fill(dp , 1);
        int ans  = 1;

        for(int i = 0 ; i <= n; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
                ans = Math.max(ans, dp[i]);
            }
        }
             return  ans;
    }

}
