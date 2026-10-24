package org.example.Study.LeetCode;

public class MaxSubProd {
    public static int maxSubProd(int[] nums){
        if(nums == null)  return 0;

        int leftMax = 0;
        int rightMax = 0;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++){
           leftMax = leftMax == 0 ?  1  : leftMax;
           rightMax = rightMax == 0 ? 1 : rightMax;

           leftMax *= nums[i];
           rightMax *= nums[nums.length-1-i];

           ans = Math.max(ans, Math.max(leftMax,rightMax));
        }
        return ans;
    }
}
