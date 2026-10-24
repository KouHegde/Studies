package org.example.Study.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class DijkstraWithNormalisation {

    static int binarySearch(List<Integer> sortedWeights) {
        int lo = 0, hi = sortedWeights.size() - 1;
        int answer = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int X   = sortedWeights.get(mid);

            if (feasible(X,new int[5][5])) {
                answer = X;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return answer;
    }

    static boolean feasible(int X, int[][] graph) {
        int[] dist = new int[5 + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;


        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 1});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int u = curr[1];

            if (cost > dist[u]) continue;

            for (int[] edge : graph) {
                int v = edge[0], w = edge[1];
                int normalCost = (w > X) ? 1 : 0;
                int newCost = cost + normalCost;

                if (newCost < dist[v]) {
                    dist[v] = newCost;
                    pq.offer(new int[]{newCost, v});
                }
            }
        }

        return dist[5] <= 3;
    }
}
