package org.example.Study.Tree;

import java.util.ArrayList;
import java.util.List;

public class PalindromePathTree {

    public static int palindromePath(int[] parent, String s){
        int n = parent.length;

        List<Integer>[] tree = new List[n];

        for(int i = 0; i < n ; i++){
            tree[i] = new ArrayList<>();
        }
        int root = 0;
        for(int i = 0; i < n ; i++){
            if(parent[i] == -1){
                root = i;
            } else{
                tree[parent[i]].add(i);
            }
        }
        return dfs(s,tree,0, root);
        }

    private static int dfs(String s, List<Integer>[] tree, int mask, int node) {
        int bit = s.charAt(node);
         mask ^= (1<<bit);

         if(tree[node] == null){
             return isPalindromic(mask) ? 1:0;
         }
         int count =0;
         for(int child : tree[node]){
             dfs(s,tree,mask,child);
         }
         return count;
    }

    private static boolean isPalindromic(int mask) {
        return (mask &(mask-1) )== 0;
    }
}
