package org.example.Study.Graphs;


//In this question you are given 3 values :
// 1. graph
// 2. weights in between their edges
// 3. You can take any path with k edges whose weight lesser than the threshold.
// Find the minimum threshold

import java.util.*;

public class GraphWithBS {
    static class Edge{
        int weight;
        int to;

        public Edge(int weight, int to){
            this.weight= weight;
            this.to = to;
        }

    }


    public static int graphTraversal(int[][] graph, int k, int source , int dest){
        Map<Integer, Map<Integer, Edge>> map = new HashMap<>();
        int max = 0;

        for (int[] edges : graph) {
            int u = edges[0];
            int v = edges[1];
            int w = edges[2];

            map.computeIfAbsent(u, key -> new HashMap<>())
                    .put(v, new Edge(w, v));
            map.computeIfAbsent(v, key -> new HashMap<>())
                    .put(u, new Edge(w, u));

            max = Math.max(max, w);
        }


        int min = 0;

        while(min<max){
            int mid = min + (max-min)/2;

            if(pathPossible(map,mid,k, source, dest, graph.length)){
                max = mid;
            } else {
                min = mid+1;
            }

        }

        return min;

    }

    private static   boolean pathPossible(Map<Integer, Map<Integer, Edge>> map,
                                        int threshold, int k, int source, int dest, int n) {
        int[] check = new int[n];
        Arrays.fill(check, Integer.MAX_VALUE);
        check[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, source});

        while (!pq.isEmpty()) {
            int[] tuple = pq.poll();
            int edgesAbove = tuple[0];
            int curr = tuple[1];

            if (edgesAbove > check[curr]) continue; // skip stale entries

            if (curr == dest &&  edgesAbove <= k) return true;

            if (!map.containsKey(curr)) continue;

            for (Edge neigh : map.get(curr).values()) {
                int cost = edgesAbove + (neigh.weight > threshold ? 1 : 0);
                if (cost < check[neigh.to]) {
                    check[neigh.to] = cost;
                    pq.add(new int[]{cost, neigh.to});
                }
            }
        }

        return check[dest] <= k;
    }



}
