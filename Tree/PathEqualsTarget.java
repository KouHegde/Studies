package org.example.Study.Tree;

import java.util.ArrayList;
import java.util.List;

public class PathEqualsTarget {
    int temp = 0;
    public int countPathEqualsTarget(Node root,int target){
        List<List<Integer>> ans  = new ArrayList<>();
        dfs(temp,root,target);
        return temp;
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


    boolean pathsum1(MaxPathSum.TreeNode node, int target){
        if(node == null) return false;


        if(node.left == null && node.right == null){
            return target == node.val;
        }

        target = target - node.val;

        return pathsum1(node.left,target) || pathsum1(node.right,target);
    }
}
