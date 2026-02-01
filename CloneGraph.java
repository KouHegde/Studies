package org.example.Study.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

//    public  Node cloneGraph(Node head){
//        if(head == null) return  head;
//        HashMap<Node,Node> map = new HashMap<>();
//        return cloneUtil(head,map);
//
//    }
//
//    private Node cloneUtil(Node node, HashMap<Node, Node> map) {
//        Node newNode  = new Node(node.val);
//        map.put(node,newNode);
//
//        for(Node n : node.neighbors){
//            if(!map.containsKey(n))
//            {
//                newNode.neighbors.add(cloneUtil(n,map));
//            }else {
//                newNode.neighbors.add(map.get(n));
//            }
//        }
//        return newNode;
//    }



    public class Node1{
        public int val;
        public List<Node> neighbours;

        public Node1(int val){
            this.val = val;
            this.neighbours = new ArrayList<>();
        }
    }




    public Node clone(Node head){
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        return cloneUtil(head, map);
    }

//    private Node cloneUtil(Node node, Map<Node, Node> map) {
//        if (map.containsKey(node)) {
//            return map.get(node);
//        }
//
//        Node newNode = new Node(node.val);
//        map.put(node, newNode);
//
//        for (Node neigh : node.neighbors) {
//            newNode.neighbors.add(cloneUtil(neigh, map));
//        }
//
//        return newNode;
//    }


//    public static Node clone(Node head){
//        if(head == null || head.neighbors == null) return head;
//        HashMap<Node,Node> map = new HashMap<>();
//        return cloneUtil(map,head);
//    }
//
//    private static Node cloneUtil(Node map, Map<Node, Node> node) {
//        Node newNode  = new Node(node.val);
//        map.put(node,newNode);
//        for(Node node1 : node.neighbors){
//            if(map.containsKey(node1)){
//                newNode.neighbors.add(node1);
//            } else {
//                newNode.neighbors.add(cloneUtil(map,node1));
//            }
//        }
//        return newNode;
//    }


    public Node cloneUtil(Node node,Map<Node,Node> map){
        if(map.containsKey(node)){
            return map.get(node);
        }

        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for(Node neigh :node.neighbors){
            newNode.neighbors.add(cloneUtil(neigh,map));
        }
        return  newNode;
    }


}
