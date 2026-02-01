package org.example.Study.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {


    public  List<Integer> boundaryTrav(Node root){
        if(root == null) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        if(!isLeaf(root))list.add(root.value);

        getLeftBoundary(list,root);
        getLeafNodes(list,root);
        getRightBoundary(list,root);

        return list;
    }

    public boolean isLeaf(Node node){
        return node.rightNode == null && node.leftNode == null;
    }

    private  void getRightBoundary(List<Integer> list, Node root) {
        Stack<Integer> st = new Stack<>();
        Node curr = root.rightNode;

        while(curr != null){
            if(!isLeaf(curr))st.push(curr.value);
            if(root.rightNode != null) curr = curr.rightNode;
            else curr = curr.leftNode;
        }
        while (!st.isEmpty()){
            list.add(st.pop());
        }
    }


    private void getLeafNodes(List<Integer> list, Node root) {
        if(isLeaf(root)){
            list.add(root.value);
            return;
        }
        if(root.leftNode != null) getLeafNodes(list,root.leftNode);
        if(root.rightNode != null) getLeafNodes(list,root.rightNode);

    }

    private void getLeftBoundary(List<Integer> list, Node root) {
        Node curr = root.leftNode;
        while(curr != null){
            if(!isLeaf(root)) list.add(root.value);
            if(root.leftNode != null) curr = curr.leftNode;
            else curr = curr.rightNode;
        }

    }


}
