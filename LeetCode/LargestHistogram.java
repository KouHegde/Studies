package org.example.Study.LeetCode;

import java.util.Stack;

public class LargestHistogram {

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        largestRectangleArea2(nums);
    }



    public static int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {

            // Pop while current bar is smaller
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = (i - stack.peek()) - 1;
                }

                max = Math.max(max, height * width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width;

            if (stack.isEmpty()) {
                width = n;
            } else {
                width = (n - stack.peek()) - 1;
            }

            max = Math.max(max, height * width);
        }

        return max;
    }



    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Previous Smaller Element
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty()
                    && heights[stack.peek()] >= heights[i]) {

                stack.pop();
            }

            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        // Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty()
                    && heights[stack.peek()] >= heights[i]) {

                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }

            stack.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int width = right[i] - left[i] - 1;

            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
