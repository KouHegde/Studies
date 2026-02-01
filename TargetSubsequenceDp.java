package org.example.Study.LeetCode;

public class TargetSubsequenceDp {

    public static boolean recSolution(int[] nums, int target, int i){
        if(target == 0 ) return  true;
        if(i ==  0 ) return nums[i] == target;

        boolean nonTake = recSolution(nums,target,i-1);
        boolean Take = false;
        if(nums[i]<target){
            Take = recSolution(nums,target-nums[i],i-1);
        }
        return nonTake || Take;
    }

    public static boolean memSol(int[] nums, int target, int i, int[][] dp) {

        if (target == 0) return true;
        if (i == 0) return nums[0] == target;

        if (dp[i][target] != -1) {
            return dp[i][target] == 1;
        }

        boolean nonTake = memSol(nums, target, i - 1, dp);
        boolean take = false;

        if (nums[i] <= target) {
            take = memSol(nums, target - nums[i], i - 1, dp);
        }

        dp[i][target] = (nonTake || take) ? 1 : 0;
        return nonTake || take;
    }

    public static boolean tabSol(int[] nums, int ans){
        boolean[][] dp = new boolean[nums.length][ans+1];
        for(int i = 0; i < nums.length; i++){
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for(int i = 1 ; i < nums.length; i++){
            for(int target= 1; target <= ans; target++){
                boolean nonTake = dp[i-1][target];
                boolean take = false;

                if (nums[i] <= target) {
                    take = dp[i-1][target-nums[i]];
                }

                dp[i][target] = take ||nonTake;
            }
        }
        return dp[nums.length-1][ans];
    }

}
