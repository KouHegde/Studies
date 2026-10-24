 package org.example.Study.LeetCode;

public class MinDifferenceSubSetSum {
    public static int minDiff(int[] nums) {

        int n = nums.length;

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        boolean[] targetArray = targetDp(total / 2, nums);

        for (int s1 = total / 2; s1 >= 0; s1--) {

            if (targetArray[s1]) {

                return total - 2 * s1;
            }
        }

        return 0;
    }

    private static boolean[] targetDp(int target, int[] nums) {

        int n = nums.length;

        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }


        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {

            for (int t = 1; t <= target; t++) {

                boolean notTake = dp[i - 1][t];

                boolean take = false;

                if (t >= nums[i]) {
                    take = dp[i - 1][t - nums[i]];
                }

                dp[i][t] = take || notTake;
            }
        }

        return dp[n - 1];
    }

}
