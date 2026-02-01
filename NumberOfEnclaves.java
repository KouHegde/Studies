package org.example.Study.LeetCode;

public class NumberOfEnclaves {
    public static int numberOfEnclave(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0 ; i < m ; i++){

            if(grid[i][0] ==1) dfs(i,0,grid);
            if(grid[i][n-1] == 1) dfs(i,n-1,grid);
        }
        for(int j =0; j < n ; j++){

            if(grid[0][j] ==1) dfs(0,j,grid);
            if(grid[m-1][j] == 1) dfs(m-1,j,grid);

        }

        int count = 0;

        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) count++;
            }
        }
        return count;
    }

    private static void dfs(int i, int j, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return;

        grid[i][j] =0;

        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j-1,grid);
        dfs(i,j+1,grid);
    }
}
