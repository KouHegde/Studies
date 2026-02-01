package org.example.Study.Graphs;

import java.util.*;

public class FlightK {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int flights(int n , int[][] graph, int source, int dest, int k){

        Map<Integer, List<Edge>> map = new HashMap<>();

        for(int [] ints : graph){
            int w = ints[0];
            int u = ints[1];
            int v = ints[2];
            map.computeIfAbsent(u,o->new ArrayList<>()).add(new Edge(v,w));
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,source,0});


        int[] distance = new int[graph.length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        while(!q.isEmpty()){
            int[] curr = q.poll();

            int step  = curr[0];
            int currNode = curr[1];
            int cost = curr[2];

            if(step>k) continue;
            for (Edge e : map.get(currNode)){
                int neigh = e.to;
                int newCost = cost+e.weight;


                if(distance[neigh] > newCost){
                    distance[neigh] = newCost;
                    q.add(new int[]{step+1,neigh,newCost});
                }
            }
        }
        return distance[dest] == Integer.MAX_VALUE ? -1 : distance[dest];
    }
}
