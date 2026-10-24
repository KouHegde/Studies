package org.example.Study.LeetCode;

import org.example.Study.Tree.MaxPathSum;
import org.example.Study.Tree.Node;

import java.util.*;

public class SerialiseDeserialiseBinaryTree {


    public String serialise(Node root){
        StringBuilder sb = new StringBuilder();
        helper1(sb, root);
        return sb.toString();
    }

    private void helper1(StringBuilder sb, Node root) {
//        if(Objects.nonNull(root) && root.leftNode == null && root.rightNode == null){
//            sb.append(root.value);
//            return;
//        }
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.value).append(",");
        helper1(sb,root.leftNode);
        helper1(sb,root.rightNode);
    }


    public Node deSerilise(String serialise){
        Queue<String> q = new LinkedList<>(Arrays.asList(serialise.split(",")));
        return helper2(q);
    }

    private Node helper2(Queue<String> q) {
        String val = q.poll();
        if(val.equals("null")) return null;
        Node node= new Node(Integer.parseInt(val));
        node.leftNode = helper2(q);
        node.rightNode = helper2(q);
        return node;
    }




    //BST
    public MaxPathSum.TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        Queue<Integer> q = new LinkedList<>();
        for (String s : data.split(",")) {
            q.add(Integer.parseInt(s));
        }

        return build(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private MaxPathSum.TreeNode build(Queue<Integer> q, int min, int max) {
        if (q.isEmpty()) return null;

        int val = q.peek();

        if (val < min || val > max) return null;

        q.poll();
        MaxPathSum.TreeNode root = new MaxPathSum.TreeNode(val);

        root.left = build(q, min, val);
        root.right = build(q, val, max);

        return root;
    }


}
