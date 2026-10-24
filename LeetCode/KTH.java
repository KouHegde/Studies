package org.example.Study.LeetCode;

import org.example.Study.Tree.MaxPathSum;

public class KTH {
    int inOrder = 0;

    public MaxPathSum.TreeNode kthSmallestInBST(MaxPathSum.TreeNode root, int k) {
        if (root == null) return null;


        MaxPathSum.TreeNode leftAns = kthSmallestInBST(root.left, k);

        if(leftAns != null) return leftAns;

        if (inOrder + 1 == k) {
            return root;
        }
        inOrder += 1;
        return  kthSmallestInBST(root.right, k);
    }

}
