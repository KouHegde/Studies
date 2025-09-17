package org.example.Study.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CycleInGraph {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {3, 4}};
        System.out.println(hasCycle(5, edges)); // Output: true
    }

    private static boolean hasCycle(int size, int[][] edges) {
        List<List<Integer>> adj = getAdjList(edges,size);
        int[] vis  = new int[size];
        for(int i = 0; i<size; i++){
            if(vis[i] == 0){
               if(dfs(i, -1,adj, vis)) return true;
            }
        }
      return false;
    }

    private static boolean dfs(int node, int parent, List<List<Integer>> adj, int[] vis) {
        vis[node] = 1;
        for(int n : adj.get(node)){
            if(vis[n] == 0){
               if(dfs(n, node, adj, vis)) return true;
            } else if(parent != n){
                return true;
            }
        }
        return false;
    }





    public static boolean cycle(int[][] graph){
        int[] arr = new  int[graph.length];
        List<List<Integer>> adj  = new ArrayList<>();
        for(int i = 0; i<graph.length ; i++){
            if(arr[i] == 0 ){
                if(cycleExist(i,-1,adj,arr)) return true;
            }
        }
        return false;
    }

    private static boolean cycleExist(int start, int parent, List<List<Integer>> adj, int[] arr) {
        arr[start] = 1;
        for(int n : adj.get(start)){
            if(arr[n] == 0){
                if(cycleExist(n,start,adj,arr)) return true;
            } else if(parent != n) return false;
        }
        return false;
    }


    private static List<List<Integer>> getAdjList(int[][] edges, int size) {

        List<List<Integer>> adj  = new ArrayList<>();

        for(int i = 0 ; i < size ; i++){
            adj.add(new ArrayList<>());
        }

        for(int [] edge : edges){
            int u  = edge[0];
            int v  = edge[1];
            adj.get(u).add(v);
        }
        return adj;
    }



    public static boolean course(int[][] graph){
        int[] arr = new int[graph.length];
        List<List<Integer>> adj  = getAdjList(graph, graph.length);
        for(int i =0; i< graph.length; i++){
            if(arr[i] == 0){
                if(cycleExist1(i,-1,adj,arr)) return false;
            }
        }
        return true;
    }

    private static  boolean cycleExist1(int start, int p,List<List<Integer>> adj, int[] arr){
        arr[start] = 1;
        for(int n : adj.get(start)){
            if(arr[n] == 0) {
                if (cycleExist1(n, start, adj, arr)) return true;
            }else if(p != n){
                return false;
            }
        }
        return false;
    }

    public boolean cyclic(int[][] graph, int size){
        List<List<Integer>> adj  = getAdjList1(graph,size);
        int[] arr = new int[size];
        for(int i =0; i< size;i++){
            if(arr[i] == 0){
                if(isCyclic(i,-1,arr,getAdjList1(graph,size))) return true;
            }
        }
        return false;
    }

    private boolean isCyclic(int i, int p, int[] arr, List<List<Integer>> graph) {
        arr[i] = 1;
        for (int n : graph.get(i)){
            if(arr[n] == 0){
                if(isCyclic(n,i,arr,graph)) return true;
            } else if(p !=n){
                return true;
            }
        }
        return false;

    }

    public List<List<Integer>> getAdjList1(int[][] graph, int size){
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0 ; i< size; i++){
            adjList.add(new ArrayList<>());
        }

        for(int n[] : graph){
            int u = n[0];
            int v= n[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }


}
