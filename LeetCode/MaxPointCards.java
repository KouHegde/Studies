package org.example.Study.LeetCode;

import static org.example.Study.LeetCode.MinLengthSubArraySize.minSubArrayLen;

public class MaxPointCards {

    public static void main(String[] args) {
        int[] nums = new int[]{9,7,7,9,7,7,9};
        int target = 7;
        int ans = maxScore(nums,target);
    }



    public static int maxScore(int[] nums, int k) {

        int n = nums.length;
        int leftSum = nums[0];
        int rightSum  = 0;
        int left = 0;
        while(left< k){
            left++;
            leftSum += nums[left];

        }
        int max = leftSum;

        for(int right = n-1; right > n-k-1; right--){
            rightSum += nums[right];
            leftSum = leftSum - nums[left];
            left--;
            max = Math.max(max,leftSum+rightSum);

        }
        return max;
    }
}
