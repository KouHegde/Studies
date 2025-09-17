package org.example.Study.LeetCode;

import java.util.Arrays;

public class RottenOranges {

    public static int rotten(int[][] grid){
        if(grid == null || grid.length ==0) return 0;
        int[][] check =  new int[grid.length][grid[0].length];

        for(int i = 0 ; i < grid.length; i++){
            Arrays.fill(check[i],Integer.MAX_VALUE);
        }

        for(int  i  = 0 ; i < grid.length ; i++){
            for(int j  = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    rDfs(i,j,grid,check,0);
                }
            }
        }
        int max = 0;
        for(int  i  = 0 ; i < grid.length ; i++){
            for(int j  = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    if (check[i][j] == Integer.MAX_VALUE)  return  -1;
                     max = Math.max(max,check[i][j]);
                }

            }
        }
        return max;
    }

    private static void rDfs(int i, int j, int[][] grid, int[][] check, int counter) {
        if(i< 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || counter >= check[i][j]) return;
        check[i][j] = counter;
         rDfs(i-1,j,grid,check,counter+1);
         rDfs(i,j-1,grid,check,counter+1);
         rDfs(i+1,j,grid,check,counter+1);
         rDfs(i,j+1,grid,check,counter+1);
    }

    
}
