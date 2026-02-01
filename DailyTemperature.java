package org.example.Study.LeetCode;

import java.util.Stack;

public class DailyTemperature {
    public static int[] daily(int[] nums){
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for(int i = 0; i < n; i++){
            int currentDay = i;

            while(!stack.isEmpty() &&  nums[currentDay] > nums[stack.peek()] ){
                int lastSmallDay = stack.pop();
                ans[lastSmallDay] = currentDay - lastSmallDay;
            }
            stack.push(currentDay);
        }
        return ans;
    }
}
