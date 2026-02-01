package org.example.Study.LeetCode;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;



public class kahnAlg {

  public static List<Integer> kahn(int[][] graph, int size){
      int[] indegree = new int[size];

      List<List<Integer>> adj = getAdj(graph,size,indegree);
      PriorityQueue<Integer> q = new PriorityQueue<>();

      for(int i = 0 ; i < size; i++){
          if(indegree[i] == 0) q.add(i);
      }
      List<Integer> top = new ArrayList<>();
      while (!q.isEmpty()){
          int curr = q.poll();
          top.add(curr);
          for(int neigh : adj.get(curr)){
              indegree[neigh] --;
              if(indegree[neigh] == 0) q.add(neigh);
          }

      }
      return size==top.size() ? top : new ArrayList<>();
  }

    private static List<List<Integer>> getAdj(int[][] graph, int size, int[] indegree) {
      List<List<Integer>> adj = new ArrayList<>();
      for(int i = 0; i < size; i++){
          adj.add(new ArrayList<>());
      }
      for(int[] n : graph){
          int u = n[0];
          int v = n[1];

          adj.get(u).add(v);
          adj.get(v).add(u);
          indegree[v]++;
      }
      return adj;
    }

}
