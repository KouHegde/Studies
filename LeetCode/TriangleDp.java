package org.example.Study.LeetCode;

import java.util.Arrays;

public class TriangleDp {

    public static int sol(int[][] grid){
        return rec(0,0,grid);
    }

    private static int rec(int i, int j, int[][] grid) {

        if (j < 0 || j >= grid[i].length) {
            return Integer.MAX_VALUE; // invalid path
        }

        if (i == grid.length - 1) {
            return grid[i][j];
        }

        int down = grid[i][j] + rec(i + 1, j, grid);
        int diag = grid[i][j] + rec(i + 1, j + 1, grid);

        return Math.min(down, diag);
    }


    private static int dpSol(int[][] grid){
        int n = grid.length;
        int[][] dp = new int[n][n];

        Arrays.fill(dp,Integer.MAX_VALUE);

        for(int j = 0 ; j < n; j++){
            dp[0][j] = grid[0][j];
        }
        for(int i  = 1; i<=n; i++){
            for(int j = 0; j<=i;j++){
                dp[i][j]= Math.min((dp[i-1][j]+grid[i][j]), (dp[i-1][j-1]+grid[i][j]));
            }
        }
        return dp[n][n];
    }


    private static int dpSol2(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        for(int[] row : dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dp[0][0] = grid[0][0];

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){

                int up = dp[i-1][j];

                int diag = Integer.MAX_VALUE;
                if(j > 0) diag = dp[i-1][j-1];

                dp[i][j] = grid[i][j] + Math.min(up, diag);
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            ans = Math.min(ans, dp[n-1][j]);
        }

        return ans;
    }
}
