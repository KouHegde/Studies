package org.example.Study.Tree;

import java.util.Objects;

public class Tree {
    Node root;

    public void insert(int data){
        root  = insertRec(data, root);
    }

    private Node insertRec(int data, Node root) {
        if(Objects.isNull(root)){
            return new Node(data);
        } else if(root.getValue() > data){
            root.setLeftNode(insertRec(data,root.getLeftNode()));
        } else {
            root.setRightNode(insertRec(data,root.getRightNode()));
        }
        return root;
    }

    public void inOrder(){
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if(root == null){
            return;
        }

        inOrderRec(root.getLeftNode());
        System.out.println(root.getValue());
        inOrderRec(root.getRightNode());
    }

    public void preOrder(){
        preOrderRec(root);
    }

    private void preOrderRec(Node root) {
        if(root == null){
            return;
        }
        System.out.println(root.getValue());
        preOrderRec(root.getLeftNode());
        preOrderRec(root.getRightNode());

    }

    private void postOrderRec(Node root) {
        if(root == null){
            return;
        }
        postOrderRec(root.getLeftNode());
        postOrderRec(root.getRightNode());
        System.out.println(root.getValue());

    }
}
