package org.example.Study.LeetCode;

public class ContTheSubsetForTargetDP {
    
    
    public static int count(int[] nums,int target){
        int n = nums.length;
        
        return recur(n-1, target,nums);
    }

    private static int recur(int i, int target, int[] nums) {
        if(i == 0) {
            if (target == 0) return 2;
            else {
                if (target == nums[0]) return 1;
                else return 0;
            }
        }
        int notPick = recur(i-1,target,nums);
        int pick = 0;
        if(nums[i] <= target) pick = recur(i-1,target-nums[i],nums);
        return pick+notPick;
    }

    private static int countDp(int[] nums,int target){
        int n = nums.length;
        int[][] dp = new int[n][target+1];

        if (nums[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
            if (nums[0] <= target) {
                dp[0][nums[0]] = 1;
            }
        }



        for(int i = 1 ; i < n; i++){
          for(int t = 0 ; t <= target; t++){
              int notPick = dp[i-1][t];
              int pick = 0;
              if(nums[i] <= t)pick = dp[i-1][t-nums[i]];
              dp[i][t] = pick+notPick;
          }
        }
        return dp[n-1][target];
    }
}
