package org.example.Study.LeetCode;


import java.util.*;


public class kahnAlg {

    public static List<Integer> kahn(int[][] edges, int n) {

        int[] indegree = new int[n];

        List<List<Integer>> adj = getAdj(edges, n, indegree);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {

            int curr = q.poll();

            topo.add(curr);

            for (int neigh : adj.get(curr)) {

                indegree[neigh]--;

                if (indegree[neigh] == 0) {
                    q.offer(neigh);
                }
            }
        }

        return topo.size() == n ? topo : new ArrayList<>();
    }

    private static List<List<Integer>> getAdj(int[][] graph, int size, int[] indegree) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : graph) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);   // directed edge

            indegree[v]++;
        }

        return adj;
    }

}
