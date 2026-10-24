package org.example.Study.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIsland2 {
    public static List<Integer> numberIsland2(int m , int n, int[][] pos){
        int[][] grid  = new int[m][n];
        List<Integer> list = new ArrayList<>();

        for(int[] poses : pos){
            grid[poses[0]][poses[1]] = 1;
            list.add(numberOfIsland(grid,m ,n));
        }
        return list;
    }

    private static Integer numberOfIsland(int[][] grid, int m, int n) {

        boolean[][] check = new boolean[m][n];
        int count = 0;

        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n ; j++ ){
                if(grid[i][j] == 1 && !check[i][j]){
                    dfs(i, j , check, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j, boolean[][] check, int[][] grid) {

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1 || check[i][j]) return;

        check[i][j] = true;
        dfs(i-1,j,check,grid);
        dfs(i+1,j,check,grid);
        dfs(i,j-1,check,grid);
        dfs(i,j+1,check,grid);


    }


}
