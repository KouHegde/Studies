package org.example.Study.LeetCode;

import java.util.*;

public class NetworkDelay {

    public int networkDelayTime(int[][] times, int n, int k) {
        if(times == null) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] node : times){
           map.computeIfAbsent(node[0],key->new ArrayList<>())
                   .add(node[1]);
        }

        int[] time  = new int[n];
        Arrays.fill(time,Integer.MAX_VALUE);

        Queue<Integer> q = new ArrayDeque<>();

        q.add(0);
        time[0] = 0;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int neigh : map.get(curr)){
                if(1+time[curr] < time[neigh]){
                    time[neigh] = 1+time[curr];
                    q.add(neigh);
                }
            }
        }
        return 0;//!distanceContainsInf(distance);
    }

        public int networkDelayTime2(int[][] times, int n, int k) {

            // adjacency list: u -> (v, w)
            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int[] t : times) {
                graph.computeIfAbsent(t[0], x -> new ArrayList<>())
                        .add(new int[]{t[1], t[2]});
            }

            // distance array
            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[k] = 0;

            // min-heap: (distance, node)
            PriorityQueue<int[]> pq =
                    new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

            pq.add(new int[]{0, k});

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int time = curr[0];
                int node = curr[1];

                // skip outdated entry
                if (time > dist[node]) continue;

                if (!graph.containsKey(node)) continue;

                for (int[] edge : graph.get(node)) {
                    int neigh = edge[0];
                    int weight = edge[1];

                    if (time + weight < dist[neigh]) {
                        dist[neigh] = time + weight;
                        pq.add(new int[]{dist[neigh], neigh});
                    }
                }
            }

            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] == Integer.MAX_VALUE) return -1;
                ans = Math.max(ans, dist[i]);
            }

            return ans;
        }
}



