package org.example.Study.LeetCode;

public class SubArrayWithBoundaries {

    public static int numberOfSubArray(int[]  nums, int minK, int maxK){
        int badIndex = -1;
        int minIndex = -1;
        int maxIndex = -1;
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == minK) minIndex = i;
            if(nums[i] == maxK) maxIndex= i;

            if(nums[i] < minK || nums[i] > maxK) badIndex = i;


            sum += Math.max(0,Math.min(minIndex,maxIndex) -badIndex);
        }
        return sum;
    }

}
