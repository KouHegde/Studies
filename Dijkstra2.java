package org.example.Study.Graphs;

import java.util.*;

class Edge {
    int to;
    int weight;

    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
    static Map<Integer, Integer> dijkstra(
            Map<Integer, List<Edge>> graph,
            int src
    ) {
        Map<Integer, Integer> dist = new HashMap<>();
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.offer(new int[]{src, 0});
        dist.put(src, 0);

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > dist.get(u)) continue;

            for (Edge e : graph.getOrDefault(u, List.of())) {
                int v = e.to;
                int newDist = d + e.weight;

                if (newDist < dist.getOrDefault(v, Integer.MAX_VALUE)) {
                    dist.put(v, newDist);
                    pq.offer(new int[]{v, newDist});
                }
            }
        }
        return dist;
    }

    static Map<Integer, List<Edge>> buildGraph(int[][] edges) {
        Map<Integer, List<Edge>> graph = new HashMap<>();

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            graph.computeIfAbsent(u, k -> new ArrayList<>())
                    .add(new Edge(v, w));


        }
        return graph;
    }
}


