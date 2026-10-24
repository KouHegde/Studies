package org.example.Study.LeetCode;

public class MaxSubArrayConstWindow {

    public double findMaxAverage(int[] nums, int k) {
        double average  = 0;
        double sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];

        }
        average = sum/k;
        System.out.println(average);

        int left  = 0;
        int right = k-1;

        while(left < nums.length-k){
            sum = sum - nums[left];
            left++;
            right++;
            sum= sum + nums[right];
            average = Math.max(average, sum/k);

        }
        return average;

    }
}
