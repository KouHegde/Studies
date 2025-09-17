package org.example.Study.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class kahnAlg {


    public static Degree getDegreeClass(int[][] graph){
        int maxNode = 0;
        for (int[] edge : graph) {
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }

        Degree degree = new Degree();
        degree.adj = new ArrayList<>();
        degree.indegree = new int[maxNode + 1];

        for (int i = 0; i <= maxNode; i++) {
            degree.adj.add(new ArrayList<>());
        }

        for (int[] edge : graph) {
            int u = edge[0];
            int v = edge[1];
            degree.indegree[v]++;
            degree.adj.get(u).add(v);
        }

        return degree;
    }

    public static int[] kahn(Degree degree){
        List<List<Integer>> adj  = degree.adj;
        Queue<Integer> queue = new LinkedList<>();

        for (int node = 0; node < degree.indegree.length; node++) {
            if (degree.indegree[node] == 0) {
                queue.add(node);
            }
        }

        int i  = 0;
        int[] top  = new int[degree.adj.size()];

        while(!queue.isEmpty()){
            int curr = queue.peek();
            queue.remove();
            top[i] = curr;
            i++;
            for(int n : adj.get(curr)){
                degree.indegree[n]--;
                if(degree.indegree[n] == 0){
                    queue.add(n);

                }
            }

        }
        return  top;
    }
}
