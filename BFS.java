package org.example.Study.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}};
        BFS bfs = new BFS();
        List<List<Integer>> adjacencyList = bfs.adjacencyList(edges);
        List<Integer> bfs1  = bfs(0,adjacencyList);
        System.out.println(adjacencyList);
    }

    public List<List<Integer>> adjacencyList(int[][] edges){
        int n = edges.length;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] edge :edges){
            int u = edge[0];
            int v  = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;

    }

    public static List<Integer> bfs(int start, List<List<Integer>> adj){
        List<Integer> bfs = new ArrayList<>();
        boolean [] visited  = new boolean[adj.size()];
        Queue<Integer> queue  = new LinkedList<>();
        queue.add(start);
        visited[start]=true;
        while(!queue.isEmpty()){
            int curr  = queue.poll();
            bfs.add(curr);
            for(int neighbor: adj.get(curr)){
                if(!visited[neighbor]){
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }

            }

        }

        return bfs;
    }

    public List<Integer> dfsOfGraphs(int start, List<List<Integer>> adj){
        boolean[] visited = new boolean[adj.size()];
        List<Integer>dfs = new ArrayList<>();
        visited[start] = true;
        dfs(start,adj,visited,dfs);
        return dfs;
    }

    public void dfs (int start,List<List<Integer>> adj,boolean[] visited,List<Integer>dfs){
        dfs.add(start);
        for(int neighbor: adj.get(start)){
            if(!visited[neighbor]){
                visited[neighbor] = true;
                dfs(neighbor,adj,visited,dfs);
            }
        }

    }

    public static List<List<Integer>> adjecencyList(int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < edges.length; i++){
            adj.add(new ArrayList<>());
        }


        for(int[] edge :edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }

    public static List<Integer> bfs (List<List<Integer>>  adj, int root){

        List<Integer> ans  = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited  = new  boolean[adj.size()];
        visited[root] = true;
        queue.add(root);

        while(!queue.isEmpty()){
            int current  = queue.poll();
            ans.add(current);
            for(int neighbour : adj.get(current)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
        return ans;

    }

    public static List<Integer> dfs(List<List<Integer>> adj, int root){

        List<Integer> ans  = new ArrayList<>();
        boolean[] visited  = new boolean[adj.size()];

        dfsCalc(ans,visited,adj,root);
        return ans;
    }

    private static void dfsCalc(List<Integer> ans, boolean[] visited, List<List<Integer>> adj, int root) {

        visited[root] = true;
        ans.add(root);

        for(int n : adj.get(root)){
            if(!visited[n]){
                dfsCalc(ans, visited, adj, n);
            }
        }
    }

}
