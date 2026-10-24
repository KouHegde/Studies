package org.example.Study.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LateralTraversal {

    public static List<Node> lateral(Node root){

        if(root == null) return null;


        List<Node> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            Node curr = q.poll();

            ans.add(curr);

            if(curr.leftNode != null) q.add(root.leftNode);
            if(curr.rightNode != null) q.add(root.rightNode);

        }

        return ans;

    }


}
