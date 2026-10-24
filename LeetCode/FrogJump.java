package org.example.Study.LeetCode;

public class FrogJump {

    class Solution {
        public int maxJump(int[] stones) {
            int n = stones.length;
            int[] dp = new int[n + 1];
            dp[0] = 0;
            for (int i = 1; i < n; i++) {
                int oneStep = dp[i - 1] + Math.abs(stones[i] - stones[i - 1]);
                int twoStep = Integer.MAX_VALUE;
                if (i > 1) twoStep = dp[i - 2] + Math.abs(stones[i] - stones[i - 2]);
                dp[i] = Math.min(oneStep, twoStep);
            }
            return dp[n - 1];
        }
    }

    public int frogJump2(int[] stones, int K ){
        int n = stones.length;
        int[] dp = new int[n];
        dp[0] = 0;

        for(int i =1 ; i < n ; i++){
            int min = Integer.MAX_VALUE;
            for(int k = 1; k <= K ; k++) {
                int tmp = 0;
                if (i - k >= 0) tmp = dp[i -k] + Math.abs(stones[i] - stones[i-k]);
                min = Math.min(min,tmp);
            }
            dp[i] = min;
        }
        return dp[n-1];
    }

    public int jump(int[] nums) {

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for(int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            if(i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                if(currentEnd >= nums.length-1) return jumps;
            }
        }

        return jumps;

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

}