package org.example.Study.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class AtlanticPacific {

    public List<List<Integer>> common(int[][] graph){
        boolean[][] pacific = new boolean[graph.length][graph[0].length];
        boolean[][] atlantic = new boolean[graph.length][graph[0].length];

        for(int i = 0; i< graph.length; i++){
            dfs(i,0,-1,-1,pacific,graph);
            dfs(i,graph[0].length-1,-1,-1,atlantic,graph);
        }

        for(int i = 0; i< graph[0].length; i++){
            dfs(0,i,-1,-1,pacific,graph);
            dfs(graph.length-1,i,-1,-1,atlantic,graph);
        }
        List<List<Integer>> results = new ArrayList<>();

        for(int i =0; i< graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(pacific[i][j] == true && atlantic[i][j] == true){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    results.add(list);
                }
            }
        }
        return results;
    }

    public void dfs(int i , int j , int oi, int oj,boolean[][] check,  int[][] graph){
        if(i<0||j<0||i>check.length||j>check[0].length||check[i][j] ||(oi<0 || oj<0 || graph[oi][oj] > graph[i][j])) return;

        check[i][j] = true;

        dfs(i-1,j,i,j,check,graph);
        dfs(i,j-1,i,j,check,graph);
        dfs(i+1,j,i,j,check,graph);
        dfs(i,j+1,i,j,check,graph);

    }
}
