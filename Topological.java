package org.example.Study.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Topological {

    public static List<Integer> topological(int[][] graph){
        List<List<Integer>>adj = getAdjList(graph);
        int[] arr = new int[graph.length];
        Stack<Integer> s = new Stack<>();
        for(int i  =0; i< graph.length; i++){
            if(arr[i] == 0){
                dfs(s,arr,adj,i);
            }
        }
        List<Integer>ans  = new ArrayList<>();
        while(!s.isEmpty()){
            ans.add(s.pop());
        }
        return ans;
    }

    public static void dfs(Stack<Integer> s, int[] arr, List<List<Integer>>adj, int start){
        arr[start] = 1;
        for(int n : adj.get(start)){
            if(arr[n] == 0){
                dfs(s,arr,adj,n);
            }
        }
        s.push(start);
    }

    private static List<List<Integer>> getAdjList(int[][] graph){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i  = 0; i< graph.length; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] n : graph){
            int u = n[0];
            int v  = n[1];
            adj.get(u).add(v);
        }
        return adj;
    }

//    public static List<Integer> top(int[][] grid){
//        List<List<Integer>> adj = getAdjList(grid);
//        int[] check = new int[grid.length];
//        Stack<Integer> s = new Stack<>();
//        for(int i = 0; i < grid.length; i++){
//            if(check[i] == 0) {
//                dfs(s, check, adj,i);
//            }
//        }
//
//    }
}
