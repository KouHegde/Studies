package org.example.Study.LeetCode;

public class UniquePaths {

    public static int sol(int[][] grid){
        int m= grid.length;
        int n  = grid[0].length;

        return recursion(m-1,n-1);
    }

    private static int recursion(int i, int j) {
        if(i == 0 && j == 0) return 1;
        if(i == -1 || j == -1) return 0;

        int up = recursion(i-1,j);
        int left = recursion(i,j-1);

        return up+left;
    }

    private static int dpSol1(int i , int j, int[][] dp ){
        if(i == 0 && j==0) return 1;
        if(i == -1 || j == -1 ) return 0;

        if(dp[i][j] != -1 ) return dp[i][j];

        int up = dpSol1(i-1,j,dp);
        int left = dpSol1(i,j-1,dp);

        return dp[i][j] =up+left;

    }

    private static int dpSol2(int[][] grid ) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                int up = (i > 0) ? dp[i - 1][j] : 0;
                int left = (j > 0) ? dp[i][j - 1] : 0;

                dp[i][j] = up + left;
            }
        }
        return dp[m - 1][n - 1];
    }

}
