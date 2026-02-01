package org.example.Study.Tree;


import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution {

    static class Pair {
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    double maxProb(int[][] graph, int[] prob, int size, int start, int end) {
        List<List<Pair>> adj = getAdj(graph, size, prob);

        double[] maxProb = new double[size];
        maxProb[start] = 1.0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.add(new Pair(start, 1.0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (curr.node == end) return curr.prob;

            if (curr.prob < maxProb[curr.node]) continue;

            for (Pair neigh : adj.get(curr.node)) {
                double max = curr.prob * neigh.prob;
                if (max > maxProb[neigh.node]) {
                    maxProb[neigh.node] = max;
                    pq.add(new Pair(neigh.node, max));
                }

            }

        }
        return 0.0;
    }

    List<List<Pair>> getAdj(int[][] graph, int size, int[] weight) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0 ; i < size; i++) {
            int u = graph[i][0];
            int v = graph[i][1];
            int w = weight[i];
            adjList.get(u).add(new Pair(v, w));
            adjList.get(v).add(new Pair(u, w));
        }
        return adjList;
    }

    //[(1,2)(2,3)(1,3)]
    //[0.5, 0.5, 0.25]
}