package org.example.Study.Graphs;

import java.util.*;

public class Dijikstra3D {

        static class Edge {
            int to;
            int fuel;
            Edge(int t, int f) {
                to = t;
                fuel = f;
            }
        }

        static class State {
            int city;
            int minFuelCost;
            long cost;

            State(int c, int m, long cost) {
                city = c;
                minFuelCost = m;
                this.cost = cost;
            }
        }

        public static long getMinCost(
                int gNodes,
                List<Integer> gFrom,
                List<Integer> gTo,
                List<Integer> gWeight,
                List<Integer> arr,
                int A,
                int B
        ) {

            // Build graph
            List<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i <= gNodes; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < gFrom.size(); i++) {
                int u = gFrom.get(i);
                int v = gTo.get(i);
                int w = gWeight.get(i);
                graph.get(u).add(new Edge(v, w));
                graph.get(v).add(new Edge(u, w));
            }

            // dist[city][minFuelCost]
            long[][] dist = new long[gNodes + 1][gNodes + 1];
            for (int i = 0; i <= gNodes; i++) {
                Arrays.fill(dist[i], Long.MAX_VALUE);
            }

            PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingLong(s -> s.cost));

            // Initial state: buy fuel at start city
            int startFuelCost = arr.get(A - 1);
            dist[A][startFuelCost] = 0;
            pq.offer(new State(A, startFuelCost, 0));

            while (!pq.isEmpty()) {
                State curr = pq.poll();

                if (curr.cost > dist[curr.city][curr.minFuelCost]) continue;

                if (curr.city == B) return curr.cost;

                for (Edge e : graph.get(curr.city)) {
                    int nextCity = e.to;

                    // Fuel price must be from CURRENT city
                    int fuelPriceHere = Math.min(curr.minFuelCost, arr.get(curr.city - 1));

                    long newCost = curr.cost + (long) e.fuel * fuelPriceHere;

                    if (newCost < dist[nextCity][fuelPriceHere]) {
                        dist[nextCity][fuelPriceHere] = newCost;
                        pq.offer(new State(nextCity, fuelPriceHere, newCost));
                    }
                }
            }

            return -1;
        }
}

