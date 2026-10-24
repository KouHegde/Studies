package org.example.Study.Graphs;

import java.util.*;

public class FlightK {
    class Solution {

        static class Edge {
            int to, weight;
            Edge(int to, int weight) {
                this.to = to;
                this.weight = weight;
            }
        }

        public static int findCheapestPrice(int n, int[][] graph, int source, int dest, int k) {
            Map<Integer, List<Edge>> map = new HashMap<>();

            for(int [] ints : graph){
                int u = ints[0];
                int v = ints[1];
                int w = ints[2];
                map.computeIfAbsent(u,o->new ArrayList<>()).add(new Edge(v,w));
            }

            PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
            q.add(new int[]{0,source,0});


            int[][] distance = new int[k+2][n];
            for (int i = 0; i <= k+1; i++) {
                Arrays.fill(distance[i], Integer.MAX_VALUE);
            }
            while(!q.isEmpty()){
                int[] curr = q.poll();

                int step  = curr[0];
                int currNode = curr[1];
                int cost = curr[2];

                if (currNode == dest) return cost;

                if(step>k) continue;
                if(!map.containsKey(currNode)) continue;


                for (Edge e : map.get(currNode)){
                    int neigh = e.to;
                    int newCost = cost+e.weight;


                    if(distance[step+1][neigh] > newCost){
                        distance[step+1][neigh] = newCost;
                        q.add(new int[]{step+1,neigh,newCost});
                    }
                }
            }
            return -1;
        }
    }

}
