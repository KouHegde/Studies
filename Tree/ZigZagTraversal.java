package org.example.Study.Tree;

import java.util.*;

public class ZigZagTraversal {

    public List<List<Integer>>  zigzagTraversal(Node root){
        if(root == null) return new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        boolean leftToRight = true;

        List<List<Integer>> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();
            Deque<Integer> deque = new ArrayDeque<>();

            for(int i = 0; i < size; i++){
                Node curr = q.poll();
                assert curr != null;
                 if(leftToRight){
                     deque.addFirst(curr.value);
                 } else{
                     deque.addLast(curr.value);
                 }

                 if(curr.leftNode != null) q.add(curr.leftNode);
                 if(curr.rightNode != null) q.add(curr.rightNode);
            }
            ans.add(new ArrayList<>(deque));
            leftToRight = !leftToRight;

        }
        return ans;

    }
}
