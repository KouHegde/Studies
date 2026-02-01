package org.example.Study.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static class Node {
        int r, c, dist;
        Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public int shortestPath(
            int[][] grid,
            int sr, int sc,
            int dr, int dc
    ) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sr, sc, 0));
        dist[sr][sc] = 0;

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Node curr = q.poll();

            int r = curr.r;
            int c = curr.c;
            int d = curr.dist;


            if (r == dr && c == dc) return d;

            for (int i = 0; i < 4; i++) {
                int nr = r + dRow[i];
                int nc = c + dCol[i];

                if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m &&
                        grid[nr][nc] == 1 &&
                        d + 1 < dist[nr][nc]) {

                    dist[nr][nc] = d + 1;
                    q.add(new Node(nr, nc, d + 1));
                }
            }
        }

        return -1; // destination not reachable
    }
}