package org.example.Study.LeetCode;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args){
        int[] nums = {1,2,3};
        int[] output =  nextPerm(nums);
    }

    private static int[] nextPerm(int[] nums) {
        int n = nums.length;
        int i = n-2;

        while(i>0 && nums[i] > nums[i+1]){
            i--;
        }

        if(i >=0){
            int j = n-1;
            while(nums[j] < nums[i]){
                j--;
            }

            int temp = nums[j];
            nums[j] = nums [i];
            nums[i] = temp;

        } else {
            return reverse(nums);
        }
        return nums;
    }

    private static int[] reverse(int[] nums){
        int start  = 0;
        int end  = nums.length-1;

        while(start <= end){

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        return nums;
    }




    private static int[] nextPermutation(int[] input){
        if(input == null) return  new int[0];

        int size  = input.length;
        int  i = size-2;

        while(input[i] > input[i+1]){
            i--;
        }
        if(i>0){
            int j = size-1;
            while(input[j] < input[i]){
                j--;
            }
            int temp = input[j];
            input[j] = input[i];
            input[i] = temp;
        } else{
            reverse(input);
        }

        return input;
    }



}
