package org.example.Study.Tree;

public class IsBalancedTree {

    public static boolean isBalancedTree(Node root){
        return helper(root) != -1;
    }

    private static int helper(Node root) {
        if(root == null) return 0;

        int lh = helper(root.leftNode);
        if(lh == -1) return -1;
        int rh = helper(root.rightNode);
        if(rh == -1) return rh;

        if(Math.abs(lh-rh)>1) return -1;

        return 1+(Math.max(lh,rh));
    }
}
