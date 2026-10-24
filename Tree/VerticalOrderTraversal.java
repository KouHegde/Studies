package org.example.Study.Tree;

import java.util.*;

public class VerticalOrderTraversal {

    class Tuple {
        int vertex;
        int level;
        Node node;

        public Tuple(int vertex, int level, Node node){
            this.level = level;
            this.vertex = vertex;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalOrderTraversal(Node root){
        if(root == null) return new ArrayList<>();

        Queue<Tuple> queue = new LinkedList<>();

        queue.add(new Tuple(0,0,root));

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map  = new TreeMap<>();

        while(!queue.isEmpty()){
            Tuple curr = queue.poll();
            int vertex = curr.vertex;
            int level = curr.level;
            Node currNode = curr.node;

            if(!map.containsKey(vertex)){
                map.put(vertex,new TreeMap<>());
            }
            if(!map.get(vertex).containsKey(level)){
                map.get(vertex).put(level,new PriorityQueue<>());
            }

            map.get(vertex).get(level).add(currNode.value);

            if(currNode.leftNode != null) queue.add(new Tuple(vertex-1,level+1,currNode.leftNode));
            if(currNode.rightNode != null) queue.add(new Tuple(vertex+1,level+1,currNode.rightNode));
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(TreeMap<Integer,PriorityQueue<Integer>> levels : map.values()){
            List<Integer> col = new ArrayList<>();
            for(PriorityQueue<Integer> valuesInEachLevel : levels.values()){
                while (!valuesInEachLevel.isEmpty()){
                    col.add(valuesInEachLevel.poll());
                }
            }
            ans.add(col);
        }

        return ans;

    }
}
