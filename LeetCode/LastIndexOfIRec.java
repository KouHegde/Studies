package org.example.Study.LeetCode;

public class LastIndexOfIRec {



    public static void main(String[] args){
        int[] nums = {1,2,3,4,1};
        int t = 1;
        calculate(0,nums, t);
    }

    private static int  calculate(int i, int[] nums, int t) {
        if(i == nums.length) return -1;

        int index = 0;

        if(nums[i] == t){
            index = i;
        }


        calculate(i+1,nums,t);
        
       
        return index;

    }

}
