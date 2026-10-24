package org.example.Study.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CycleInGraph {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {3, 4}};
        System.out.println(hasCycle(edges, 5)); // Output: true
    }



   public static boolean hasCycle(int[][] graph, int size){
        List<List<Integer>> adj = getAdj(graph,size);
        boolean[] visited = new boolean[size];
        for(int i = 0 ; i< size; i++){
            if(!visited[i]) {
                if (dfs(i, -1, adj, visited)) {
                    return true;
                }
            }
        }
        return  false;

   }

    private static boolean dfs(int current, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[current] = true;

        for (int neigh : adj.get(current)){
            if(!visited[neigh]){
                if(dfs(neigh,current,adj,visited)){
                    return true;
                }
            } else if(parent != neigh){
                return true;
            }
        }
        return false;
    }

    private static boolean dfsDirected(int current, boolean[] check, List<List<Integer>> adj, boolean[] rac) {
        check[current] = true;
        rac[current] = true;

        for(int neigh : adj.get(current)){
            if(!check[neigh]){
                if(dfs(neigh,current,adj,check)){
                    return true;
                }
            } else if(rac[neigh]){
                return true;
            }
        }
        rac[current] = false;
        return false;
    }

    private static List<List<Integer>> getAdj(int[][] graph, int size) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i<size; i++){
            list.add(new ArrayList<>());
        }
        for(int[] n : graph){
            int  u = n[0];
            int v = n[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }

        return list;
    }


}
