package org.example.Study.Tree;

import java.util.ArrayList;
import java.util.List;

public class PathToDest {
    public List<Integer> path(Node root, int target){
        List<Integer> ans = new ArrayList<>();
        pathFinder(root,target,ans);
        return ans;
    }

    private boolean pathFinder(Node node, int target, List<Integer> ans) {
        if(node == null) return false;

        ans.add(node.value);

        if(node.value == target) return true;

        boolean left = pathFinder(node.leftNode,target,ans);
        boolean right = pathFinder(node.rightNode,target,ans);

        if(left || right) return true;

        else {
            ans.remove(ans.size()-1);
            return false;
        }
    }
}
