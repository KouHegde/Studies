package org.example.Study.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LateralTraversal {

    public static List<Node> lateralTraversal(Node root){
        if(root == null) return new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        List<Node> l = new ArrayList<>();

        q.add(root);

        while(q!= null){
            Node cur = q.poll();
            l.add(cur);

            if( cur.getLeftNode() != null) q.add(cur.getLeftNode());
            if(cur.getLeftNode() != null) q.add(cur.getRightNode());

        }
        return l;
    }
}
