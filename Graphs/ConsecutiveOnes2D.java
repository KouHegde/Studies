package org.example.Study.Graphs;

public class ConsecutiveOnes2D {

    public static int calculate(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] check = new boolean[m][n];
        int max = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                if(grid[i][j] == 1 && !check[i][j]){

                    int count = dfs(i, j, grid,check);
                    max = Math.max(count,max);

                }
            }
        }
        return max;
    }

    public static  int dfs(int i, int j, int[][] grid, boolean[][] check ){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || check[i][j] || grid[i][j] == 0) return 0;
        check[i][j] = true;
        int count = 1;

        count += dfs(i-1, j, grid,check);
        count +=  dfs(i, j-1, grid,check);
        count +=  dfs(i+1, j, grid,check);
        count += dfs(i, j+1, grid,check);
        return count;
    }
}
