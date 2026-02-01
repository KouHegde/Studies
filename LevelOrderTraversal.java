package org.example.Study.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public List<List<Integer>> LOT(Node root){
        if(root == null) return new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i < level; i++){
                Node curr = q.poll();
                assert curr != null;
                if(curr.leftNode != null) q.add(curr.leftNode);
                if(curr.rightNode != null) q.add(curr.rightNode);
                temp.add(curr.value);
            }
            ans.add(temp);
        }

        return ans;
    }

}
