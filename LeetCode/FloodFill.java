package org.example.Study.LeetCode;

public class FloodFill {
    public static int[][] floodFill(int[][] grid, int startRow, int startCol, int newColor){
        int startColor = grid[startRow][startCol];

        if(startColor == newColor) return grid;

        dfs(startRow,startCol,grid,startColor,newColor);

        return grid;
    }

    private static void dfs(int startRow, int startCol, int[][] grid, int startColor,int newColor) {
        if(     startRow < 0
                || startRow > grid.length-1
                || startCol < 0
                || startCol > grid[0].length-1
                || grid[startRow][startCol] != startColor
        ) return;

        grid[startRow][startCol] = newColor;

        dfs(startRow-1,startCol,grid,startColor,newColor);
        dfs(startRow,startCol-1,grid,startColor,newColor);
        dfs(startRow+1,startCol,grid,startColor,newColor);
        dfs(startRow,startCol+1,grid,startColor,newColor);

    }
}
