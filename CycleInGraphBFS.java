package org.example.Study.LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CycleInGraphBFSUnDireceted {
    public boolean isCycle(int[][] graph, int start, List<List<Integer>> adj){
        int n = graph.length;

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[start] = true;
        q.add(new int[]{start,-1});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int val= curr[0];
            int parent = curr[1];

            for(int neigh : adj.get(val)){
                if(!visited[neigh]){
                    visited[neigh] = true;
                    q.add(new int[]{neigh,val});
                }
                else if(neigh != parent){
                    return false;
                }
            }
        }
        return true;
    }
}
