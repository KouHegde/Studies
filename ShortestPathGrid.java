package org.example.Study.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathGrid {
    static class Tuple {
        int first, second, third;

        public Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }


    public static int shortPath(int[][] grid, int[] source, int[] dest) {
        if (source[0] == dest[0] && source[1] == dest[1]) return 0;

        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Tuple> q = new LinkedList<>();

        dist[source[0]][source[1]] = 0;
        q.add(new Tuple(0, source[0], source[1]));

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            int dis = tuple.first;
            int row = tuple.second;
            int col = tuple.third;

            if (row == dest[0] && col == dest[1]) return  dis;
            for (int i = 0; i < 4; i++) {

                int newr = row + dr[i];
                int newc = col + dc[i];

                if (newr >= 0 && newr < n && newc >= 0 && newc < m && grid[newr][newc] == 1 && 1 + dis < dist[newr][newc]) {
                    dist[newr][newc] = 1 + dis;
                    q.add(new Tuple(1 + dis, newr, newc));
                }
            }
        }
        return -1;
    }
}
