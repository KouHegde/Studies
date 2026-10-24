package org.example.Study.LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Swim {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = grid[0][0];
        pq.offer(new int[]{0, 0, grid[0][0]});

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], cost = curr[2];

            if (r == n - 1 && c == n - 1) return cost;

            if (cost > dist[r][c]) continue;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                    int newCost = Math.max(cost, grid[nr][nc]);

                    if (newCost < dist[nr][nc]) {
                        dist[nr][nc] = newCost;
                        pq.offer(new int[]{nr, nc, newCost});
                    }
                }
            }
        }

        return -1;
    }

}
