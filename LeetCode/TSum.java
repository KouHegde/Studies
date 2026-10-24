package org.example.Study.LeetCode;

import java.util.*;

public class TSum {


    public static Set<List<Integer>>  setthreeS(int[] nums , int target){
        if(nums == null || nums.length < 3){
            return new HashSet<>();
        }

        Arrays.sort(nums);
        Set<List<Integer>>  set  = new HashSet<>();

        for(int i =0 ;i<nums.length-2; i++){
            int  left  = i+1;
            int right  = nums.length-1;
            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if( target == sum){
                    set.add(Arrays.asList( nums[left] + nums[right] + nums[i]));
                    left++;
                    right--;
                }
                if(sum > target){
                    right--;
                } else {
                    left++;
                }
            }

        }
        return set;
    }

    public static HashSet<List<Integer>> threeSome(int[] nums,int t){
        if(nums ==null|| nums.length<3){
            return new HashSet<>();
        }

        Arrays.sort(nums);
        HashSet<List<Integer>> set= new HashSet<>();

        for(int i =0; i< nums.length-2; i++){
            int left = i+1;
            int right =  nums.length-2;

            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if (t == sum){
                     set.add(Arrays.asList(nums[i],nums[left],nums[right]));
                }
                if(sum>t){
                    right--;
                }else{
                    left++;
                }
            }


        }
        return set;
    }






public static Set<List<Integer>> threeess(int[] nums , int target){

        Arrays.sort(nums);
        Set<List<Integer>> set  = new HashSet<>();

        for(int i  = 0; i < nums.length; i++){
            int left  = i+1;
            int right =  nums.length -1;

            while(left <= right){
                int sum = nums[left] + nums[right] + nums[i];
                if(sum < target){

                }else{

                }

            }



        }
        return set;
}


}
