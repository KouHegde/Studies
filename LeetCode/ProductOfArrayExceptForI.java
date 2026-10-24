package org.example.Study.LeetCode;

public class ProductOfArrayExceptForI {
    public static void main(String[] args){

        int[] nums  = {1,2,3,4};
        int[] ans  = productOfArrayExcept(nums);
        System.out.print(ans);

    }

    public static int[] productOfArrayExcept(int[] nums){
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];


        prefix[0] = 1;

        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        suffix[n-1] = 1;

        for(int i = n-2;i>-1; i++ ){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        int[] ans = new int[n];

        for(int i = 0 ; i < n ; i++){
            ans[i] = prefix[i] * suffix[i];
        }
        return ans;

    }







}
