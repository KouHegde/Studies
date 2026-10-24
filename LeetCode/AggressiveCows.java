package org.example.Study.LeetCode;

import java.util.Arrays;

public class AggressiveCows {
    public int calculate(int[] nums, int n ){

        Arrays.sort(nums);

        int size = nums.length;
        int left = 1;
        int right = nums[size-1] - nums[0];

        while(left <right){
            int mid = left+(right-left)/2;

            if(canFit(mid,nums,n)){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }

    private boolean canFit(int mid, int[] nums, int n) {
        int count = 1;
        int place = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(Math.abs(place - nums[i]) >= mid){
                count++;
                place = nums[i];
            }
        }
        return count >= n;
    }
}
