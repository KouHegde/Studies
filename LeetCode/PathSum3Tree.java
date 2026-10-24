package org.example.Study.LeetCode;

import org.example.Study.Tree.MaxPathSum;

import java.util.HashMap;
import java.util.Map;

public class PathSum3Tree {
    public int pathSum(MaxPathSum.TreeNode root, int targetSum) {
        Map<Integer, Integer> pathMap = new HashMap<>();
        pathMap.put(0,1);
        int[] total = new int[1];
        helper(pathMap, 0, root, targetSum, total);
        return total[0];

    }

    public void helper(Map<Integer, Integer> pathMap , int currSum, MaxPathSum.TreeNode root, int targetSum, int[] total){
        if(root == null) return;

        currSum += root.val;

        total[0] += pathMap.getOrDefault(currSum-targetSum,0);
        pathMap.put(currSum,pathMap.getOrDefault(currSum,0)+1);

        helper(pathMap, currSum, root.left, targetSum,total);
        helper(pathMap, currSum, root.right, targetSum,total);
        pathMap.put(currSum, pathMap.get(currSum) -1);
    }
}
