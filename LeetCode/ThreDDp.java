package org.example.Study.LeetCode;

public class ThreDDp {
//    public static int sol(int[][] grid){
//
//
//    }

    private int recSol(int i, int j1, int j2, int[][] grid) {

        if (j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length) {
            return Integer.MIN_VALUE;
        }

        if (i == grid.length - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        int maxi = Integer.MIN_VALUE;

        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value;
                if (j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];

                value += recSol(i + 1, j1 + dj1, j2 + dj2, grid);
                maxi = Math.max(maxi, value);
            }
        }
        return maxi;
    }

    private int dpSol(int[][] grid, int i, int j1, int j2, int[][][] dp){

        if (j1 <0 || j1 > grid.length || j2 < 0 || j2 > grid[0].length){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        if (i == 0) {
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        int maxi =0;
        for(int dj1 = -1; dj1 < 1;  dj1++){
        for(int dj2 = -1; dj2 < 1; dj2++){
            int val = 0;
            if(j1 ==  j2) val= grid[i][j1];
            else  val = grid[i][j1] + grid[i][j2];
            val += dpSol(grid,i+1,dj1+j1,dj2+j2,dp);
            maxi = Math.max(maxi,val);
            }
        }
        return dp[i][j1][j2] = maxi;

    }
}
