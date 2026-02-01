package org.example.Study.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    public static int numberOfProv(int[][] graph){

        boolean[] visited = new boolean[graph.length];

        int count = 0;
        for(int i = 0 ; i < graph.length; i++){
            if(!visited[i]){
                dfs(i,graph,visited);
                count++;
            }
        }

        return count;

    }

    private static void dfs(int city, int[][] graph, boolean[] visited) {
        visited[city] = true;

        for(int dest =0 ; dest < graph[city].length; dest++){
            if(graph[city][dest] == 1 && !visited[dest]){
                dfs(dest,graph,visited);
            }
        }
    }
}
