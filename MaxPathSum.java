package org.example.Study.Tree;

public class MaxPathSum {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        static int  ans;
        public int maxPathSum(TreeNode root) {
            if (root == null) return 0;
            findMaxPathSum(root);
            return ans;
        }

        public int findMaxPathSum(TreeNode root) {
            if (root == null) return 0;

            int leftSum = findMaxPathSum(root.left);
            leftSum = leftSum < 0 ? 0 : leftSum;
            int rightSum = findMaxPathSum(root.right);
            rightSum = rightSum < 0 ? 0 : rightSum;

            ans = Math.max(ans, (root.val + leftSum + rightSum));

            return root.val + Math.max(leftSum, rightSum);
        }
    }

    public static void main(String[] args) {
        // Create a simple binary tree:
        //        -10
        //        /  \
        //       9   20
        //           / \
        //          15  7

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        Solution sol = new Solution();
        int result = sol.maxPathSum(root);
        System.out.println("Max Path Sum: " + result);
    }
}