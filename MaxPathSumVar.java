package org.example.Study.LeetCode;

public class MaxPathSumVar {
    public static int minpathSumVar(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        return rec(m-1,n-1,grid,m ,n);
    }

    private static int rec(int i, int j, int[][] grid, int m, int n) {
        if(i == 0){
            return grid[0][j];
        }
        if(j <0 || j >m-1){
            return Integer.MAX_VALUE;
        }

        int up = grid[i][j] + rec(i-1,j,grid,m,n);
        int dia1 = grid[i][j] + rec(i-1,j-1,grid,m,n);
        int dia2 = grid[i][j] + rec(i-1,j+1,grid,m,n);

        return Math.min(up,Math.min(dia1,dia2));
    }

    public class MinFallingPathSum {

        public static int dpSol(int[][] grid) {
            int m = grid.length;        // rows
            int n = grid[0].length;     // columns

            int[][] dp = new int[m][n];

            // Base case: first row
            for (int j = 0; j < n; j++) {
                dp[0][j] = grid[0][j];
            }

            // Fill DP table
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    int up = dp[i - 1][j];

                    int diagLeft = (j > 0)
                            ? dp[i - 1][j - 1]
                            : Integer.MAX_VALUE;

                    int diagRight = (j < n - 1)
                            ? dp[i - 1][j + 1]
                            : Integer.MAX_VALUE;

                    dp[i][j] = grid[i][j]
                            + Math.min(up, Math.min(diagLeft, diagRight));
                }
            }

            // Result: minimum in last row
            int ans = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                ans = Math.min(ans, dp[m - 1][j]);
            }

            return ans;
        }


    }
}
