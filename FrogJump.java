package org.example.Study.LeetCode;

public class FrogJump {

    class Solution {
        public int maxJump(int[] stones) {
            int n = stones.length;
            int[] dp = new int[n + 1];
            dp[0] = 0;
            for (int i = 1; i < n; i++) {
                int left = dp[i - 1] + Math.abs(stones[i] - stones[i - 1]);
                int right = Integer.MAX_VALUE;
                if (i > 1) right = dp[i - 2] + Math.abs(stones[i] - stones[i - 2]);
                dp[i] = Math.min(left, right);
            }
            return dp[n - 1];
        }
    }
}

    /* Var2
    for (int i = 1; i < n; i++) {
    int left = Math.abs(stones[i] - stones[i - 1]);
    int right = Integer.MIN_VALUE;

    if (i > 1)
        right = Math.abs(stones[i] - stones[i - 2]);

    max = Math.max(max, Math.max(left, right));
}
     */



