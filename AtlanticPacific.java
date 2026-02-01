package org.example.Study.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AtlanticPacific {

    public List<List<Integer>> common(int[][] height){
        int m  = height.length;
        int n = height[0].length;

        boolean[][] atlantic = new boolean[m][n];
        boolean[][] pacific = new boolean[m][n];

        for(int  i = 0; i < m; i++){
            dfs(0,i,-1,-1,height,atlantic,m,n);
            dfs(n-1,i,-1,-1,height,pacific,m,n);
        }
        for(int i = 0 ; i< n; i++){
            dfs(i,0,-1,-1,height,atlantic,m,n);
            dfs(i,m-1,-1,-1,height,pacific,m,n);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < m ; i++){
            for(int j =0; j < n ; j++){
                if(atlantic[i][j] && pacific[i][j]){
                    List<Integer> curr = new  ArrayList<>();
                    curr.add(i);
                    curr.add(j);
                    ans.add(curr);
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j, int oi, int oj, int[][]height, boolean[][] ocean, int m ,int n){
        if((i<0 || i>=m && j <0 || j >= n || ocean[i][j]) || (oi >= 0 && oj >= 0 && height[i][j] < height[oi][oj] )) return;

        ocean[i][j] = true;

        dfs(i - 1, j, i, j, height, ocean,m,n);
        dfs(i + 1, j, i, j, height, ocean,m,n);
        dfs(i, j -1 , i, j, height, ocean,m,n);
        dfs(i, j +1, i, j, height, ocean,m,n);

    }





    public List<List<Integer>> commonInBoth(int[][] graph) {
        int m = graph.length;
        int n = graph[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs1(i, 0, -1, -1, pacific, graph);      // Pacific left edge
            dfs1(i, n - 1, -1, -1, atlantic, graph); // Atlantic right edge
        }
        for (int j = 0; j < n; j++) {
            dfs1(0, j, -1, -1, pacific, graph);      // Pacific top edge
            dfs1(m - 1, j, -1, -1, atlantic, graph); // Atlantic bottom edge
        }

        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    results.add(Arrays.asList(i, j));
                }
            }
        }
        return results;
    }

    public void dfs1(int i, int j, int oi, int oj, boolean[][] ocean, int[][] graph) {
        if (i < 0 || j < 0 || i >= graph.length || j >= graph[0].length || ocean[i][j] ||
                (oi >= 0 && oj >= 0 && graph[i][j] < graph[oi][oj])) return;

        ocean[i][j] = true;

        dfs1(i - 1, j, i, j, ocean, graph);
        dfs1(i + 1, j, i, j, ocean, graph);
        dfs1(i, j - 1, i, j, ocean, graph);
        dfs1(i, j + 1, i, j, ocean, graph);
    }


}
