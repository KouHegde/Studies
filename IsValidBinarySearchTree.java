package org.example.Study.Tree;

public class IsValidBinarySearchTree {

    public boolean isValidBST(Node root){
        return isValid(root,Long.MAX_VALUE,Long.MAX_VALUE);
    }

    private boolean isValid(Node root, long left, long right) {
        if(root == null) return true;
        if(root.value <= left || root.value >= right) return false;
        return isValid(root.leftNode,left, root.value) && isValid(root.rightNode,root.value,right);
    }

}
