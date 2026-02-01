package org.example.Study.Graphs;

import java.util.ArrayList;
import java.util.List;

public class CriticalConnection {

        int time  = 0;
        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

            List<List<Integer>> adj = new ArrayList<>();

            for(int i  = 0 ; i < n; i++){
                adj.add(new ArrayList<>());
            }
            for(List<Integer> edge: connections){
                adj.get(edge.get(0)).add(edge.get(1));
                adj.get(edge.get(1)).add(edge.get(0));
            }

            int[] vis = new int[n];
            int[] intime = new int[n];
            int[] low = new int[n];

            List<List<Integer>> ans = new ArrayList<>();

            dfs(0,-1,vis,intime,low,ans,adj);
            return ans;

        }

        public void dfs(int node, int parent, int[] vis, int[] iti, int[] low, List<List<Integer>> ans,List<List<Integer>> adj){
            vis[node] = 1;

            iti[node] = low[node] = time;

            time++;

            for(int neigh : adj.get(node)){
                if(neigh == parent) continue;

                if(vis[neigh] != 1){
                    dfs(neigh,node,vis,iti,low,ans,adj);
                    low[node] = Math.min(low[node],low[neigh]);
                    if(low[neigh] > iti[node]){
                        ans.add(List.of(node,neigh));
                    }
                } else{
                    low[node] = Math.min(low[node],low[neigh]);
                }
            }

        }
}

