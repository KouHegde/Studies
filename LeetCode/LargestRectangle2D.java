package org.example.Study.LeetCode;

import java.util.Stack;

public class LargestRectangle2D {


    public int maximalRectangle(char[][] nums) {
        int m = nums.length;
        int n = nums[0].length;

        int[] height = new int[n];
        int max = 0;
        for(int i = 0; i <  m ; i++){
            for(int j = 0; j < n ; j++){
                if(nums[i][j] == '1'){
                    height[j]++;
                } else {
                    height[j]= 0;
                }
            }
            int current = largestRectangleArea(height);
            System.out.println(current);
            max = Math.max(max, current);
        }
        return max;
    }


    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] left = new int[n];   // NSL
        int[] right = new int[n];  // NSR

        Stack<Integer> stack = new Stack<>();

        // 1️⃣ Find Next Smaller to Left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // clear stack
        stack.clear();

        // 2️⃣ Find Next Smaller to Right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // 3️⃣ Calculate max area
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

}
