package org.example.Study.Graphs;

import java.util.*;

public class ShortestPathDijkstra {

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static List<Integer> shortestPath(int[][] edges, int src, int dst, int n) {

        // Build adjacency list
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(new Edge(e[1], e[2]));
            adj.get(e[1]).add(new Edge(e[0], e[2])); // undirected
        }

        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        dist[src] = 0;
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];

            if (d > dist[node]) continue;

            for (Edge e : adj.get(node)) {
                int nd = d + e.weight;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    parent[e.to] = node;
                    pq.add(new int[]{e.to, nd});
                }
            }
        }

        // No path
        if (dist[dst] == Integer.MAX_VALUE) return List.of(-1);

        // Reconstruct path
        LinkedList<Integer> path = new LinkedList<>();
        for (int cur = dst; cur != -1; cur = parent[cur]) {
            path.addFirst(cur);
        }

        return path;
    }
}