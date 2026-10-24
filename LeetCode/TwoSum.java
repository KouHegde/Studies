package org.example.Study.LeetCode;

import java.util.*;

public class TwoSum {

    public static void main(String[] args){
        int[] nums  = {5,4,8,3,2};

        List<Integer> ans  = twoSum(nums, 6);

    }

    public static List<Integer> twoSum(int[] nums, int target) {
        if (nums.length < 2) return null;

        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            int diff = target - num;

            if (seen.contains(diff)) {
                return Arrays.asList(diff, num); // pair found
            }

            seen.add(num);
        }

        return new ArrayList<>(); // no pair found
    }

    public static List<Integer> twoSum1(int[] nums, int target){
        HashMap<Integer,Integer> map  = new HashMap<>();
        List<Integer> ans  = new ArrayList<>();

        for(int n : nums){
            int diff = target - n;

            if(map.containsKey(diff)){
                ans.add(n);
                ans.add(diff);
            } else{
                map.put(n,diff);
            }

        }
        return ans;
    }






    public static List<Integer> twoSumxqsx(int[] nums,int target){

        Arrays.sort(nums);
         int left  = 0;
         int right = nums.length-1;

         while(left<right){
             int sum  = nums[left] + nums[right];
             if(sum == target) {
                 return Arrays.asList(nums[left],nums[right]);
             }
             if(sum< target){
                 left++;
             }else{
                 right--;
             }
         }

        return new ArrayList<>();
    }


}
