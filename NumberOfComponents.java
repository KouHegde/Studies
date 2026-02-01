package org.example.Study.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfComponents {

    public int componentsCount(int[][] graph , int n){
        List<List<Integer>> adj = getAdjList(graph,n);
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0; i< n; i++){
            if(!visited[i]){
                dfs(i,adj,visited);
                count++;
            }
        }
        return count;
    }
    private List<List<Integer>> getAdjList(int[][] graph, int size){
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i< size; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: graph){
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }

    private void dfs(int start,List<List<Integer>> adj, boolean[] visited){
        visited[start] = true;
        for(int n : adj.get(start)){
            if(!visited[n]){
                dfs(n,adj,visited);
            }
        }
    }
}
