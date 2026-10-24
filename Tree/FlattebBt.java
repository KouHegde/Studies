package org.example.Study.Tree;

public class FlattebBt {

    Node prev  = null;

    public void flatten(Node root){
        if(root == null) return;

        flatten(root.rightNode);
        flatten(root.leftNode);


        root.leftNode = null;
        root.rightNode = prev;

        prev = root;
    }
}
