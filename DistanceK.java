package org.example.Study.Tree;

import java.util.*;

public class DistanceK {

    public static List<Integer> distanceK(Node root, Node target, int k) {
        Map<Node,Node> parentMap = new HashMap<>();
        createParentMap(root,null,parentMap);

        List<Integer> ans = new ArrayList<>();
        Set<Node> visited = new HashSet<>();

        dfs(target,0,parentMap,k,ans,visited);
        return ans;
    }

    private static void dfs(Node node, int distance, Map<Node, Node> parentMap, int k, List<Integer> ans, Set<Node> visited) {
        if((node == null) || visited.contains(node) || distance > k) return;

        visited.add(node);

        if(distance == k){
            ans.add(node.value);
            return;
        }

        dfs(node.leftNode,distance+1,parentMap,k,ans,visited);
        dfs(node.rightNode,distance+1,parentMap,k,ans,visited);
        dfs(parentMap.get(node),distance+1,parentMap,k,ans,visited);
    }

    private static void createParentMap(Node root, Node parentNode, Map<Node, Node> parentMap) {
        if(root == null) return;

        parentMap.put(root,parentNode);
        createParentMap(root.leftNode,root,parentMap);
        createParentMap(root.rightNode,root,parentMap);

    }


    public static List<Integer> bfs(Node root, Node target, int k ){
        Map<Node,Node> map = new HashMap<>();
        createParentMap(root,null,map);

        Set<Node> visited  = new HashSet<>();
        Queue<Node> q = new LinkedList<>();

        q.add(target);
        visited.add(target);

        int count = 0;

        while(!q.isEmpty()){
            if(count == k) break;
            int size = q.size();
            count++;
            for(int i = 0; i < size; i++){
                Node curr = q.poll();

                if(curr.leftNode != null && !visited.contains(curr.leftNode)){
                    visited.add(curr.leftNode);
                    q.add(curr.leftNode);
                }
                if(curr.rightNode != null && !visited.contains(curr.rightNode)){
                    visited.add(curr.rightNode);
                    q.add(curr.rightNode);
                }
                if(map.get(curr) != null && !visited.contains(map.get(curr))){
                    visited.add(map.get(curr));
                    q.add(map.get(curr));
                }
            }

        }

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            ans.add(q.poll().value);
        }

        return  ans;

    }


    }
