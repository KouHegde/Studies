package org.example.Study.Graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectionRequired {

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];

        int numberOfComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis);
                numberOfComponents++;
            }
        }
        return numberOfComponents - 1;
    }


    public void dfs(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for (int neigh : adj.get(node)) {
            if (!vis[neigh]) {
                dfs(neigh, adj, vis);
            }
        }
    }

}
