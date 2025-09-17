package org.example.Study.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeastCommonAncestor {


    public static Node leastCommonAncestor(Node p, Node q , Node root){
        if(root == null || q == null || p == null){
            return root;
        }
        Node left = leastCommonAncestor(root.getLeftNode(), p, q);
        Node right  = leastCommonAncestor(root.getRightNode(),p,q);
        if(left == null){
            return right;
        } else if(right == null){
            return left;
        }else {
            return root;
        }
    }



}
