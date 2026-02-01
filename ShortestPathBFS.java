package org.example.Study.Graphs;

import java.util.*;

public class ShortestPathBFS {

    public static int[] shortestPathBFS(int[][] graph,int src, int size){
        if(graph.length == 0 ) return new int[size];

        List<List<Integer>> adj = getAdj(graph,size);

        Queue<Integer> queue = new LinkedList<>();

        int[] distance = new int[size];

        Arrays.fill(distance,Integer.MAX_VALUE);

        queue.add(src);
        distance[src] = 0;
        while (!queue.isEmpty()){
            Integer curr = queue.poll();

            for(int neigh : adj.get(curr)){
                if(distance[curr] + 1 < distance[neigh]){
                    distance[neigh] = distance[curr]+1;
                    queue.add(neigh);
                }
            }
        }
        return distance;
    }

    private static List<List<Integer>> getAdj(int[][] graph, int size) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < size ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] ints : graph){
            int u = ints[0];
            int v = ints[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
}
