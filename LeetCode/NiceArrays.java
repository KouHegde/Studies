package org.example.Study.LeetCode;

public class NiceArrays {
    public int numberOfSubArrays(int[] nums, int k){
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }

    private static int countAtMost(int[] nums, int m) {
        if(m < 0) return 0;

        int left = 0;
        int count = 0;
        int sum =0;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            sum += nums[i] %2;

            while(sum > m){
                sum = sum - (nums[left] % 2);
                left++;
            }

            if(sum <= m){
                count += (i-left + 1);
            }
        }
        return count;
    }
}
