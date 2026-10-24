package org.example.Study.LeetCode;

public class CountTheNumberOfSquares {
    public int countSquares(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;


        int[][] dp = new int[m][n];

        int count = 0;
        for(int i = 0; i < m; i++){
            if(nums[i][0] == 1){
                dp[i][0] = 1;
                count++;
            }
        }
        for(int j = 1; j < n; j++){
            if(nums[0][j] == 1){
                dp[0][j] = 1;
                count++;
            }
        }

        for(int i = 1 ; i< m; i++){
            for(int j = 1; j < n; j++){
                if(nums[i][j] == 1){
                    int value = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    dp[i][j] = 1 + value;

                }
                count += dp[i][j];
            }
        }

        return count;

    }
}
