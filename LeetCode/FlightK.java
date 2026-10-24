package org.example.Study.LeetCode;

import java.util.*;

public class FlightK {

    public static void main(String[] args) {
        // Number of nodes
        int n = 4;

        // Flights as [from, to, price]
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };

        // Define source, destination, and max stops
        int src = 0;
        int dst = 3;
        int k = 1; // you can change this to test
        int cheapest = findCheapestPrice(n, flights, src, dst, k);

        System.out.println("Cheapest Price from " + src + " to " + dst + " with max " + k + " stops: " + cheapest);
    }


    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new HashMap<>());
            map.get(flight[0]).put(flight[1], flight[2]);
        }

        // dist[node][stops] = cheapest cost to reach `node` with `stops` stops
        int[][] dist = new int[n][k + 2];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[src][0] = 0;

        // PQ: [cost, node, stops]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int node = curr[1];
            int stops = curr[2];

            if(stops > k) continue;
            if(cost > dist[node][stops]) continue;

            if (stops <= k && map.containsKey(node)) {
                for (int next : map.get(node).keySet()) {
                    int newCost = cost + map.get(node).get(next);

                    // prune if already found cheaper
                    if (newCost < dist[next][stops + 1]) {
                        dist[next][stops + 1] = newCost;
                        pq.add(new int[]{newCost, next, stops + 1});
                    }
                }
            }
        }
        return dist[dst][k];
    }

    public static int findCheapestPrice(int src, int dst, int[][] flights, int n, int k) {

        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            graph[flight[0]].add(new int[]{
                    flight[1],
                    flight[2]
            });
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // dist[stops][node]
        int[][] dist = new int[k + 2][n + 1];

        for (int i = 0; i < k + 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][src] = 0;

        // {cost, node, stopsUsed}
        pq.add(new int[]{0, src, 0});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int cost = curr[0];
            int node = curr[1];
            int stops = curr[2];

            if (node == dst) {
                return cost;
            }

            if (stops == k + 1) {
                continue;
            }

            for (int[] next : graph[node]) {

                int nextNode = next[0];
                int price = next[1];

                int newCost = cost + price;

                if (newCost < dist[stops + 1][nextNode]) {

                    dist[stops + 1][nextNode] = newCost;

                    pq.add(new int[]{
                            newCost,
                            nextNode,
                            stops + 1
                    });
                }
            }
        }

        return -1;
    }
}


