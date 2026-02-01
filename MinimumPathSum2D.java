package org.example.Study.LeetCode;

public class MinimumPathSum2D {

    public static int minRec(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        return rec(n-1,m-1,grid);
    }

    private static int rec(int i, int j, int[][] grid) {

        if(i == 0 && j == 0) return grid[i][j];

        if(i == -1 && j == -1) return Integer.MAX_VALUE;


        int up = grid[i][j] + rec(i-1,j,grid);
        int down = grid[i][j] + rec(i, j-1,grid);
        return Math.min(up,down);
    }


    private static int dpSol(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        dp[0][0] = grid[0][0];

        for(int i  = 0; i < n; i++){
            for(int j =0 ; j < m; j++){
                if(i ==0 && j == 0) continue;
                int up =Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;

                if(i>0) up = grid[i][j] + dp[i-1][j];
                if(j>0) left = grid[i][j] + dp[i][j-1];


                dp[i][j] = Math.min(up,left);
            }
        }
        return dp[m-1][n-1];
    }
}
