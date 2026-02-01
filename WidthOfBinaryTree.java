package org.example.Study.Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {
   static class Pair{
        int index;
        Node node;

        Pair(int i, Node node){
            this.index = i;
            this.node = node;
        }
    }
    public static int width(Node root){
         if(root == null) return 0;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0,root));

        int max =-1;

        while(!q.isEmpty()){
            int size  = q.size();
            int min  = q.peek().index;
            int left = 0;
            int right = 0;

            for(int i=0; i < size; i++){

                Pair curr = q.poll();
                int currIndex = curr.index;
                int idx = currIndex-min;
                if(i == 0) left = currIndex;
                if(i == size-1) right = currIndex;

                if(root.leftNode != null) q.add(new Pair(2*idx+1,root.leftNode ));
                if(root.rightNode != null) q.add(new Pair(2*idx+2,root.rightNode ));
            }
            max = Math.max(max,(right-left)+1);
        }

        return max;
    }
}
