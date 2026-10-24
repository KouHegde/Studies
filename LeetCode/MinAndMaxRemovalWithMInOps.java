package org.example.Study.LeetCode;

public class  MinAndMaxRemovalWithMInOps {


    public static void main(String[] args){
        int[] nums = {-87,60,-30,-67,74,55,76,-53};
        minimumDeletions(nums);
    }
    public static int minimumDeletions(int[] nums) {

        int minPos = 0;
        int maxPos  = 0;
        int n = nums.length;
        if(n<= 1) return 1;

        for(int i = 0 ; i<nums.length; i++){
            if(nums[minPos] > nums[i]){
                minPos = i;
            }
            if(nums[maxPos] < nums[i]){
                maxPos = i;
            }
        }


        int ansleft = (minPos + maxPos) ;
        int ansRight = (2*n) - ansleft  +1;
        int split = minPos + (n - maxPos) + 1;
        int split2 = maxPos + (n - minPos) + 1;




        return Math.min(ansleft,Math.min(ansRight,Math.min(split2,split)));


    }
}
