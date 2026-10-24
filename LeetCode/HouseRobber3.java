package org.example.Study.LeetCode;

import org.example.Study.Tree.MaxPathSum;

public class HouseRobber3 {

    public int rob(MaxPathSum.TreeNode root) {
        int[] ans = travel(root);
        return Math.max(ans[0], ans[1]);
    }

    public int[] travel(MaxPathSum.TreeNode root) {
        if (root == null) return new int[2];

        int[] left = travel(root.left);
        int[] right = travel(root.right);

        int[] ans = new int[2];

        ans[0] = root.val + left[1] + right[1];
        ans[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return ans;
    }

    public int rob3(MaxPathSum.TreeNode root){
        int[] ans = rebPractice(root);
        return Math.max(ans[0],ans[1]);
    }

    private int[] rebPractice(MaxPathSum.TreeNode root) {

        if(root == null) return new int[2];

        int[] left = rebPractice(root.left);
        int[] right = rebPractice(root.right);

        int[] current = new int[2];

        current[0] = root.val + left[1] + right[1];
        current[1] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);

        return current;
    }

}
