package org.example.Study.LeetCode;

import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {

    public Integer find3SumClosest(int[] nums, int target){

        Arrays.sort(nums);

        int closest = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < nums.length-2; i++){

            int  l  = i+1;
            int r = nums.length-1;
            while(l < r) {

                int tempClosest = nums[l] + nums[i] + nums[r];

                if (Math.abs(target - tempClosest) < Math.abs(target - closest)) closest = tempClosest;

                if (tempClosest < target) l++;
                else if (tempClosest > target) r--;
                else return target;
            }

        }
        return closest;
    }
}
