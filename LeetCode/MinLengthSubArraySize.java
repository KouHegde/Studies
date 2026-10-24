package org.example.Study.LeetCode;

public class MinLengthSubArraySize {

    public static void main(String[] args){
        int[] nums = new int[] {2,3,1,2,4,3};
        int target = 7;
        int ans  = minSubArrayLen(target,nums);

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left  = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;


        while(right < nums.length){
            if(sum <= target){
                sum += nums[right];
                right++;
            }
            while(sum >= target){
                sum = sum - nums[left];
                left++;
                min = Math.min(min, (right - left) + 1);

            }


        }
        return min != Integer.MAX_VALUE ?  min : 0;
    }


    public static int maxSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int max = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum > target) {
                sum -= nums[left];
                left++;
            }
            if(sum>= target) max = Math.max(max, right - left + 1);

        }

        return max;
    }
}
