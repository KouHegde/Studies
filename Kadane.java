package org.example.Study.LeetCode;

public class Kadane {

    public static void main(String[] args){
        int[] nums  = {1,-1,2,4,-2,-3,8};
        int ans  = kadane2(nums);
    }

    private static int kadaneAlgo(int[] nums) {
        int cur = nums[0];
        int max = nums[0];

        for(int i = 1; i < nums.length;i++){
            cur = Math.max(nums[i],cur+nums[i]);
            max = Math.max(cur,max);
        }
        return max;
    }

    private static int kadane2(int[] nums){
        int sum =0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i< nums.length; i++){
         sum += nums[i];
         if(sum>max){
             max = sum;
         }
         if(sum < 0){
             sum =0;
         }
        }
        return max;
    }


    public int kadane3(int [] nums){
        int sum  = 0;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            sum += num;
            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }


    public int kadane(int[] nums){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int n:nums){
            sum+=n;
            if(sum>max){
                max = sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }




}
