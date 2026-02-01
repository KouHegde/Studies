package org.example.Study.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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

            if (node == dst) return cost;

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
        return -1;
    }

    public static int flights(int src, int dst, int[][] flights,int n , int k){
        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();

        for(int[] flight : flights){
            map.putIfAbsent(flight[0],new HashMap<>());
            map.get(flight[0]).put(flight[1],flight[2]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        int[][] check = new int[n][k+2];

        for(int i = 0 ;i< n ;i++){
            Arrays.fill(check,Integer.MAX_VALUE);
        }

        pq.add(new int[] {0,src,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0];
            int dest = curr[1];
            int stops = curr[2];

            if(dest ==  dst) return cost;

            if(stops < k && map.containsKey(dest)){
                for(int next : map.get(dest).keySet()){
                    int newCost = cost + map.get(dest).get(next);

                    if(newCost < check[next][k+1]){
                        check[next][k+1] = newCost;
                        pq.add(new int[]{newCost,next,k+1});
                    }
                }
            }

        }
        return -1;

    }
}


