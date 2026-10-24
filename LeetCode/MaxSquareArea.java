package org.example.Study.LeetCode;

public class MaxSquareArea {


    public int maximalSquare(char[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[][] dp = new int[m][n];

        int max = 1;

        for(int j = 0 ; j < n; j++ ) {
            dp[m - 1][j] = nums[m - 1][j] == '1' ? 1 : 0;
        }
        for(int j = 0 ; j < m; j++ ){
            dp[j][n-1] = nums[j][n-1]  == '1' ? 1: 0;
        }

        for(int i = m-2; i >= 0 ; i--){
            for(int j = n-2; j>=0; j--){
                if(nums[i][j] == '1'){
                    int value = Math.min(dp[i+1][j], Math.min(dp[i][j+1], dp[i+1][j+1]));
                    dp[i][j] = 1 + value;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
