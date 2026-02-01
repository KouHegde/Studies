package org.example.Study.Tree;

import java.util.ArrayList;
import java.util.List;

public class AnyPathEqualsTarget {
    int temp = 0;
    public  List<List<Integer>> anyPathEqualsTarget(Node root,int target){
        List<List<Integer>> ans  = new ArrayList<>();
        dfs(temp,root,target);
        return ans;
    }

    private  void dfs( int count, Node root,int target) {
        if(root == null) return;

        if(target - root.value >= 0){
            target = target-root.value;
        }
        if(target == 0) count  = count+1;

        dfs(count,root.leftNode,target);
        dfs(count,root.rightNode,target);
    }
}
