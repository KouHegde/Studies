package org.example.Study.LeetCode;

public class NumberOfIsland {

//    public static int numberOfIsland(char[][] grid){
//        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
//        int count  = 0;
//        for(int i  = 0; i< grid.length ; i++){
//            for(int  j = 0; j < grid[0].length; j++){
//                if(grid[i][j] == 1){
//                    dfs(i,j,grid);
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//    public static void dfs(int rows, int columns, char[][] grid){
//        if(rows<0 || columns < 0 || rows > grid.length || columns > grid[0].length || grid[rows][columns] ==0) return;
//        grid[rows][columns] = 0;
//
//        dfs(rows-1,columns,grid);
//        dfs(rows+1,columns,grid);
//        dfs(rows,columns-1,grid);
//        dfs(rows,columns+1,grid);
//    }





    public static int number(int[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0 ) return 0;

        int count  = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j  = 0; j< grid[0].length;j++){
                dfsIslands(i,j,grid);
                count++;
            }
        }
        return count;
    }

    private static void dfsIslands(int i, int j, int[][] grid) {
        if(i<0||j<0||i > grid.length || j > grid[0].length || grid[i][j]==0) return;
        grid[i][j] =0;
        dfsIslands(i-1,j,grid);
        dfsIslands(i,j-1,grid);
        dfsIslands(i+1,j,grid);
        dfsIslands(i,j+1,grid);
    }

}
