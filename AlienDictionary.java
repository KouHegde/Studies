package org.example.Study.LeetCode;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
public class AlienDictionary {

    public static String alienDict(List<String> dict,int k, int n){
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[k];
        for(int i = 0; i < k ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++){
            String s1 = dict.get(i);
            String s2 = dict.get(i+1);

            for(int j = 0 ; j < Math.min(s1.length(), s2.length()); j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    adj.get(s1.charAt(j) -'a').add(s2.charAt(j) - 'a');
                    inDegree[s2.charAt(j) -'a']++;
                }
            }
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i = 0 ; i < k ; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();

        while(!q.isEmpty()){
            int curr = q.poll();
            topo.add(curr);

            for(int neigh: adj.get(curr)){
                inDegree[neigh]--;
                if(inDegree[neigh] == 0)q.add(neigh);
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < k ; i++){
            sb.append(topo.get(i) + 'a');
        }
        return sb.toString();
    }
}
