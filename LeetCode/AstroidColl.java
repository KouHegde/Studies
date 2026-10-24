package org.example.Study.LeetCode;

import java.util.Stack;

public class AstroidColl {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int current : asteroids) {
            boolean isDestroyed = false;

            while (!stack.isEmpty() && stack.peek() > 0 && current < 0) {
                int prev = stack.peek();

                if (Math.abs(prev) < Math.abs(current)) {
                    stack.pop();
                } else if (Math.abs(prev) == Math.abs(current)) {
                    stack.pop();
                    isDestroyed = true;
                    break;
                } else {
                    isDestroyed = true;
                    break;
                }
            }

            if (!isDestroyed) {
                stack.push(current);
            }
        }

        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
