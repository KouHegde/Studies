package org.example.Study.LeetCode;

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

        for(int j = 0 ; j < n; j++){
            dp[n-1][j] = grid[n-1][j];
        }
        for(int i  = n-2; i>=0; i++){
            for(int j = 0; j<=i;j++){
                dp[i][j]= Math.max((dp[i+1][j]+grid[i][j]), (dp[i+1][j+1]+grid[i][j]));
            }
        }
        return dp[0][0];
    }
}
