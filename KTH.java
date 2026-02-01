package org.example.Study.LeetCode;

import org.example.Study.Tree.MaxPathSum;

public class KTH {
    int preOrder = 0;

    public MaxPathSum.TreeNode kthSmallestInBST(MaxPathSum.TreeNode root, int k) {
        if (root == null) return null;


        MaxPathSum.TreeNode leftAns = kthSmallestInBST(root.left, k);

        if(leftAns != null) return leftAns;

        if (preOrder + 1 == k) {
            return root;
        }
        preOrder += 1;
        return  kthSmallestInBST(root.right, k);
    }

}
