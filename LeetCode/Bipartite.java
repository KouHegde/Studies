package org.example.Study.LeetCode;

import org.example.Study.Tree.Node;

import java.util.*;

public class Bipartite {
    public static boolean isBipartiteGraph(int[][] graph, int size){
        int[] color = new int[size];
        for(int i = 0 ; i < size; i++){
            Arrays.fill(color,-1);
        }

        for(int i = 0; i<size; i++){
            if(color[i] ==-1){
                if(isBipartite(i,graph,color)) return true;
            }
        }
        return false;

    }

    private static boolean isBipartite(int i, int[][] graph, int[] color) {
        color[i] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int neigh: graph[curr]){
                if(color[neigh] == -1){
                    color[neigh] = 1-color[curr];
                    q.add(neigh);
                } else if(color[neigh] == color[curr]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
    }


}
