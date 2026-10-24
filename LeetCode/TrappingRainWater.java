package org.example.Study.LeetCode;



public class TrappingRainWater {

    public static void main(String[] args){
        int[] height = {4,1,5,0,1};

    }



    public static int trap(int[] nums){

        if(nums == null) return 0;

        int[] left = new int[nums.length];

        left[0] = nums[0];

        for(int i = 1; i <= nums.length-1; i++){
            left[i] = Math.max(nums[i], left[i-1]);
        }

        int[] right = new int[nums.length];

        right[nums.length-1] = nums[nums.length-1];

        for(int i = nums.length-2; i>=0; i++){
            right[i] = Math.max(nums[i],right[i+1]);
        }

        int ans = 0;

        for (int i = 0; i < nums.length; i++ ){
            ans += Math.min(left[i],right[i]) - nums[i];
        }
        return ans;
    }

    public static int trapHard1(int[] nums){
       int n = nums.length;

       int l = 0;
       int r = n-1;

       int lmax = 0;
       int rmax = 0;

       int ans = 0;

       while(l<=r){
           lmax = Math.max(lmax,nums[l]);
           rmax = Math.max(rmax,nums[r]);

           if(lmax<rmax){
               ans += lmax - nums[l];
               l++;
           } else {
               ans += rmax - nums[r];
               r--;
           }
       }
        return ans;
    }




}
