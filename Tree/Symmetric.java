package org.example.Study.Tree;

public class Symmetric {

    public boolean isSymmetric(Node root){
        if(root == null) return true;

        return helper(root.leftNode, root.rightNode);
    }

    private boolean helper(Node leftNode, Node rightNode) {
        if(leftNode == null && rightNode == null) return true;
        if(leftNode == null || rightNode == null) return false;

        return leftNode.value == rightNode.value && helper(leftNode.leftNode,rightNode.rightNode) && helper(leftNode.rightNode,rightNode.leftNode);
    }

}
