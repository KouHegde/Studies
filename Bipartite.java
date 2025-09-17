package org.example.Study.LeetCode;

import org.example.Study.Tree.Node;

import java.util.*;

public class Bipartite {

    public static boolean bipartite(int[][] graphs){

        int[] check = new int[graphs.length];
        Arrays.fill(check,-1);

        for(int i  = 0; i< graphs.length; i++){
            if(check[i] == -1){
                if(!isBipartite(graphs,i,check)) return false;
            }
        }
        return true;

    }

    private static boolean isBipartite(int[][] graphs, int start, int[] check) {
        check[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int curr  = queue.poll();
            for(int n : graphs[curr]){
                if(check[n] == -1){
                    check[n] = 1- check[curr];
                    queue.add(n);
                } else if(check[curr] == check[n]) return false;

            }


        }
        return true;
    }





    public boolean isBipertite(int[][] graph){
        if(Objects.isNull(graph)){
            return false;
        }
        int[] check = new int[graph.length];
        Arrays.fill(check,-1);

        for(int i = 0; i< graph.length;i++){
            if(check[i] == -1){
                if(!bipartite1(graph,check,i)) return false;
            }
        }
        return true;
    }

    public boolean bipartite1(int[][] graph, int[] check,int start){
        check[start] = 0;
        Queue<Integer>queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int n : graph[curr]){
                if(check[n]== -1){
                    check[n]= 1-check[curr];
                    queue.add(n);
                } else if(check[curr] == check[n]) return false;
            }
        }
        return true;

    }








    public static void main(String[] args) {
        
    }


}
