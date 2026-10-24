package org.example.Study.Tree;

import java.util.*;

public class BurnTree {
    private static Node findTarget(Node root, int target) {
        if (root == null) return null;

        if (root.value == target) return root;

        Node left = findTarget(root.leftNode, target);
        if (left != null) return left;

        return findTarget(root.rightNode, target);
    }

    private static void createParentMap(Node root, Node parent, Map<Node, Node> parentMap) {
        if (root == null) return;

        parentMap.put(root, parent);

        createParentMap(root.leftNode, root, parentMap);
        createParentMap(root.rightNode, root, parentMap);
    }


    public static int burnTree(Node root, int target) {
        Map<Node, Node> parentMap = new HashMap<>();
        createParentMap(root, null, parentMap);

        Node targetNode = findTarget(root, target);
        if (targetNode == null) return 0;

        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        q.add(targetNode);
        visited.add(targetNode);

        int time = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            time++;

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (curr.leftNode != null && visited.add(curr.leftNode)) {
                    q.add(curr.leftNode);
                }

                if (curr.rightNode != null && visited.add(curr.rightNode)) {
                    q.add(curr.rightNode);
                }

                Node parent = parentMap.get(curr);
                if (parent != null && visited.add(parent)) {
                    q.add(parent);
                }
            }
        }

        return time;
    }
}
