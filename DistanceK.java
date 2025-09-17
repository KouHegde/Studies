package org.example.Study.Tree;

import java.util.*;

public class DistanceK {

    public static List<Integer> distanceK(Node root, Node target, int k) {
        Map<Node,Node> parents  = new HashMap<>();
        popParents(root,parents);
        Queue<Node> q = new LinkedList<>();
        Map<Node,Boolean> check  = new HashMap<>();
        check.put(target,true);
        q.add(target);
        int level  = 0;
        while(!q.isEmpty()){
            int size  = q.size();
            if(level == k) break;
            level++;
            for(int i  = 0 ; i < size; i++) {
                Node curr=q.poll();
                if (curr.leftNode != null && check.get(curr.leftNode) == null) {
                    check.put(curr.leftNode, true);
                    q.offer(curr.leftNode);
                }
                if (curr.rightNode != null && check.get(curr.rightNode) == null) {
                    check.put(curr.rightNode, true);
                    q.offer(curr.rightNode);
                }
                if (parents.get(curr) != null && check.get(parents.get(curr)) == null) {
                    check.put(parents.get(curr), true);
                    q.offer(parents.get(curr));
                }
            }
        }

        List<Integer> ans  = new ArrayList<>();
        while(!q.isEmpty()){
            Node curr   = q.poll();
            ans.add(curr.value);
        }
        return ans;
    }

    private static void popParents(Node root, Map<Node, Node> parents) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node curr = q.poll();

            if(curr.leftNode != null){
                parents.put(curr.leftNode,curr);
                q.offer(curr.leftNode);
            }
            if(curr.rightNode != null){
                parents.put(curr.rightNode,curr);
                q.offer(curr.rightNode);
            }
        }
    }
}
