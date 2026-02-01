package org.example.Study.LeetCode;

import java.util.*;

public class Three {


    public static Set<List<Integer>> threeSum(int[] nums, int target) {
        if(nums.length < 3) return new HashSet<>();

        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();

        for(int i = 0; i < nums.length-2; i++){
            int left = i+1;
            int right  = nums.length-1;

            while (left < right){
                int sum = nums[left] + nums[right] + nums[i];

                if(sum == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);

                    ans.add(list);

                    left++;
                    right--;
                } else if(sum <target){
                    left++;
                } else {
                    right --;
                }

            }

        }
        return ans;
    }
}


