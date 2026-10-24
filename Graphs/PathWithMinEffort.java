package org.example.Study.Graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinEffort {

    public int pathWithMinEffort(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Tuple> pq =
                new PriorityQueue<>((a, b) -> a.ans - b.ans);

        dist[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));

        int[] rowVar = {1, 0, -1, 0};
        int[] colVar = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            Tuple curr = pq.poll();
            int r = curr.row;
            int c = curr.col;
            int effort = curr.ans;

            if (effort > dist[r][c]) continue;

            for (int i = 0; i < 4; i++) {
                int nr = r + rowVar[i];
                int nc = c + colVar[i];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int nextEffort =
                            Math.max(effort,
                                    Math.abs(heights[nr][nc] - heights[r][c]));

                    if (nextEffort < dist[nr][nc]) {
                        dist[nr][nc] = nextEffort;
                        pq.add(new Tuple(nr, nc, nextEffort));
                    }
                }
            }
        }
        return dist[m-1][n-1];
    }


    class Tuple{
        int row;
        int col;
        int ans;

        public Tuple(int row,int col, int ans){
            this.col = col;
            this.row = row;
            this.ans = ans;
        }
    }
}
